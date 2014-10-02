package recfun

object trial {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(506); 

  def countChange(money: Int, coins: List[Int]): Int = {
    def help(change: Int, remCoins: List[Int], num: Int): Int = {
      if (remCoins.isEmpty) {
        if (change == money) num + 1 else num
      } else {
        if (change == money) help(change, remCoins.tail, num) else {
          if (change > money) num else {
            help(change + remCoins.head, remCoins, num) + help(change, remCoins.tail, 0)
          }
        }
      }
    }
    help(0, coins, 0)
  };System.out.println("""countChange: (money: Int, coins: List[Int])Int""");$skip(26); val res$0 = 

  countChange(1, List());System.out.println("""res0: Int = """ + $show(res$0))}
}
