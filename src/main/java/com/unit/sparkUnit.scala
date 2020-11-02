package com.unit

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object sparkUnit {
    val conf: SparkConf = new SparkConf().setAppName("demo").setMaster("local[2]")
    val sc = new SparkContext(conf)

  private def startProAnalyse(filename: String): RDD[((Int, Int, String), Int)] = {
    // 导入csv文件并用指定分隔符切分
    val lines = sc.textFile(filename, 4)
      .map(_.split(","))
    // 取出需要的列,整理成(种类号, 商品号，用户行为), 个数
    lazy val line = lines.map(s => ((s(2).toInt, s(1).toInt, s(3)), 1))
    // 统计个数
    line.reduceByKey(_+_)
  }

  def findSaltedPro(filename: String = "D:\\UserBehavior_0.csv", num: Int = 10): String = {
    val line = startProAnalyse(filename)
    val result = line.filter(x => "buy".equals(x._1._3))
      .map(x => (x._1._2, x._2)).reduceByKey(_ + _)
    sortAndTake(result, num)
  }

  def findSaltedType(filename: String = "D:\\UserBehavior_0.csv", num: Int = 10): String = {
    val line = startProAnalyse(filename)
    val result = line.filter(x => "buy".equals(x._1._3))
      .map(x => (x._1._1, x._2)).reduceByKey(_ + _)
    sortAndTake(result, num)
  }

  private def sortAndTake(result: RDD[(Int, Int)], num: Int): String = {
    var resStr: String = "{"
    //升序的话，sortBy(...,true)
    val sortedRes = result.sortBy(_._2, ascending = false)
    sortedRes.take(num).foreach(x => resStr += "\""+ x._1 + "\":\"" + x._2 +"\",")
    resStr.substring(0, resStr.length-1)+ "}"
  }
}
