import scala.util.control.Breaks.{break, breakable}

/*
  A[i] + A[j] == K を満たす i<j の存在判定
  整数K
  整数配列A
*/
/* 
  exp:
  input: 12 1 2 3 4 5 6 9
  K = 12 
  A = Array(1, 2, 3, 4, 5, 6, 9)
*/

object Equation2{
  def main(args: Array[String]){
    println("A[i] + A[j] == K を満たす i<j の存在判定を行います...")
    println("整数K入力してください")
    println("exp:12")

    var input: Array[Int] = Array.empty
    input = readLine.split(" ").map(_.toInt)
    while(input.length != 1) {
      println("入力する数値は1つにしてください")
      input = readLine.split(" ").map(_.toInt)
    }

    val K = input(0).toInt

    println("整数配列Aを半角スペース区切りで入力してください")
    println("exp:1 2 3 4 5 6 9")
    var A: Array[Int] = Array.empty
    A = readLine.split(" ").map(_.toInt)
    while(A.length <= 1) {
      println("整数配列には2つ以上の数値を設定してください")
      A = readLine.split(" ").map(_.toInt)
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