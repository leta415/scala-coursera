package recfun

object trial {

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
  }                                               //> countChange: (money: Int, coins: List[Int])Int

  countChange(1, List())                          //> res0: Int = 0
}