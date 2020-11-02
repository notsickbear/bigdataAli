import com.unit.sparkUnit
import org.junit.jupiter.api.Test

class testSparkUnit {

  @Test def testFindSaltedPro(): Unit = {
    val result = sparkUnit.findSaltedPro()
    println(result)
  }

  @Test def testFindSaltedType(): Unit = {
    val result = sparkUnit.findSaltedType()
    println(result)
  }
}
