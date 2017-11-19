import breeze.linalg._
import breeze.numerics._

/*
  ax+by=c, dx+ey=f の二元連立一次方程式を計算する

  exp:
  input: 1 2 3 4 5 6
  →
  x + 2y = 3
  4x + 5y = 6
  (x = -1, y =2)
*/

object Equation{
  def main(args: Array[String]){
    println("ax+by=c, dx+ey=f の二元連立一次方程式を計算します...")
    println("必要な変数をaから半角スペース区切りの数値で入力してください")
    println("exp:1 2 4 5 -7 9")

    var input: Array[Int] = Array.empty
    input = readLine.split(" ").map(_.toInt)
    while(input.length != 6) {
      println("入力する数値は6つにしてください")
      input = readLine.split(" ").map(_.toInt)
    }

    val a = input(0).toDouble
    val b = input(1).toDouble
    val c = input(2).toDouble
    val d = input(3).toDouble
    val e = input(4).toDouble
    val f = input(5).toDouble

    val ad = DenseVector(a, d)
    val be = DenseVector(b, e)
    val cf = DenseVector(c, f)
    val (x, y) = solve(ad, be, cf)
    if (x.isInfinite) {
      println("解が存在しません")
    } else {
      if (round(x) == 0 && round(y) == 0)
        println("解が複数存在します")
      else
        println(s"x = $x, y = $y")
    }
  }

  def solve(ad: DenseVector[Double], be: DenseVector[Double], cf: DenseVector[Double]): (Double, Double) = {
      val x = det(DenseMatrix(cf, be)) / det(DenseMatrix(ad, be))
      val y = det(DenseMatrix(ad, cf)) / det(DenseMatrix(ad, be))
      (x, y)
  }
}