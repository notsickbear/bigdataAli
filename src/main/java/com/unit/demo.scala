package com.unit

object demo {
  def main(args: Array[String]): Unit = {
    /*    val filename = "D:\\UserBehavior_0.csv"
    //val filename = "D:\\test.csv"
    val conf = new SparkConf().setAppName("").setMaster("local[2]")
    val sc = new SparkContext(conf)
    // 导入csv文件并用指定分隔符切分
    val lines = sc.textFile(filename, 2).map(_.split(",|，|\t| |、"))
    // 取出需要的列,整理成(商品号，种类号, 用户行为), 个数
    /*    val line = lines.map(s => {
          var i = 1
          val behavior = s(1)
          if ("pv".equals(behavior)) i = 1
          else if("buy".equals(behavior)) i = 10
          else if("cart".equals(behavior)) i = 7
          else if("fav".equals(behavior)) i = 5
          ( (s(2).toInt, s(1).toInt), i )
        })*/
    val line = lines.map(s => ((s(2).toInt, s(1).toInt, s(3)), 1))
    // 统计个数
    val point = line.reduceByKey(_+_)
    point.foreach(println)
    /*    val typeTable = point.map(x=> (x._1._2, x._2)).reduceByKey(_+_)*/*/
    /*var resMap: Map[String, Int] = Map()
    sortedRes.take(num).foreach(i => {resMap += (i._1.toString -> i._2)})*/
    /* Array[(Int, Int)]*/
    /*Map[String, Int]*/

    /*    //java Map ==> scala Map
    import scala.collection.JavaConversions.mapAsScalaMap
    val scalaMap1: scala.collection.mutable.Map[String, String] = javaMap*/
  }
}
