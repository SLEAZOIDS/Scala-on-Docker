import scala.util.control.Breaks.{break, breakable}

/*
  A[i] + A[j] == K を満たす i<j の存在判定
  整数K
  整数配列A
*/
/* 
  exp:
  args: 12 1 2 3 4 5 6 9
  K = 12 
  A = Array(1, 2, 3, 4, 5, 6, 9)
*/

object Equation2{
  def main(args: Array[String]){
    val K = args(0).toInt
    var A: Array[Int] = Array.empty
    
    for ((number, index) <- args.zipWithIndex) {
      if (index != 0)
        A = A :+ number.toInt
    }
    
    //以下は必ずcombinations(0)<combinations(1)の組み合わせとなる
    val combinations = A.combinations(2).toList

    var is_solved = false
    breakable {
      for (combination <- combinations) {
        if (combination(0) + combination(1) == K) {
          println("与えられた数値は条件を満たします")
          println(s"${combination(0)} + ${combination(1)} = $K")
          is_solved = true
          break
        }
      }
    }

    if (is_solved == false)
      println("与えられた数値では条件を満たせません")
  }

}