package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int =
    if (c == 0 || (c == r)) 1 else pascal(c - 1, r - 1) + pascal(c, r - 1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean =
    {
      def countParens(remChars: List[Char], parens: Int): Boolean =
        if (remChars.isEmpty) parens == 0 else {
          if (parens < 0) false else {
            if (remChars.head == '(') countParens(remChars.tail, parens + 1) else {
              if (remChars.head == ')') countParens(remChars.tail, parens - 1) else countParens(remChars.tail, parens)
            }
          }
        }
      
      countParens(chars, 0)
    }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = 
  {
    def permutChange(change: Int, remCoins: List[Int], num: Int): Int = {
      if (remCoins.isEmpty) {
        if (change == money) num + 1 else num
      } else {
        if (change == money) permutChange(change, remCoins.tail, num) else {
          if (change > money) num else {
            permutChange(change + remCoins.head, remCoins, num) + permutChange(change, remCoins.tail, 0)
          }
        }
      }
    }
    permutChange(0, coins, 0)
  }  
}