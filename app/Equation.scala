import breeze.linalg._
import breeze.numerics._

/* ax+by=c, dx+ey=f の二元連立一次方程式を計算する
  args a b c d e f
*/

object Equation{
  def main(args: Array[String]){
    val a = args(0).toDouble
    val b = args(1).toDouble
    val c = args(2).toDouble
    val d = args(3).toDouble
    val e = args(4).toDouble
    val f = args(5).toDouble

    val ad = DenseVector(a, d)
    val be = DenseVector(b, e)
    val cf = DenseVector(c, f)
    val (x, y) = solve(ad, be, cf)
    val rx = round(x)
    val ry = round(y)
    println(s"x = $rx  y = $ry")
  }

  def solve(ad: DenseVector[Double], be: DenseVector[Double], cf: DenseVector[Double]): (Double, Double) = {
      val x = det(DenseMatrix(cf, be)) / det(DenseMatrix(ad, be))
      val y = det(DenseMatrix(ad, cf)) / det(DenseMatrix(ad, be))
      (x, y)
  }
}