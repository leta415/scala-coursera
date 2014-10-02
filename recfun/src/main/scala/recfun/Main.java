package recfun;

public class Main {
	public static void main (String[] args) {
		int num = new Main().countChange(5, new int[]{1,2,5});
		System.out.println("Number of ways: " + num);
	}
	public int countChange (int money, int[] coins) {
		return permutChange (money, 0, coins, 0);
	}
	public int permutChange (int money, int currentChange, int[] remCoins, int num) {
		System.out.println("permutChange(" + money + ", " + currentChange + ", " + arrayToStr(remCoins) + ", " + num + ")");
		
		if (remCoins.length == 0) {
			if (money == currentChange) {
				return num + 1;
			} else {
				return num;
			}
		}
		if (currentChange == money) {
			return permutChange(money, currentChange, tail(remCoins), num);
		} else if (currentChange > money) {
			return num;
		} else {
			return permutChange(money, currentChange + head(remCoins), remCoins, num) + permutChange(money, currentChange, tail(remCoins), 0);		
		}
	}
	
	public int head (int[] array) {
		return array[0];
	}
	public int[] tail (int[] array) {
		int[] tail = new int[array.length-1]; 
		for (int i = 1; i < array.length; i++) {
			tail[i-1] = array[i]; 
		}
		return tail;
	}
	public String arrayToStr (int[] array) {
		String s = "";
		s += "[";
		for (int i = 0; i < array.length; i++) {
			s += array[i];
			if (i < array.length - 1) {
				s += ", ";
			}
		}
		s += "]";
		return s;
	}
//    def permutChange(change: Int, remCoins: List[Int], num: Int): Int = {
//    	      if (remCoins.isEmpty) {
//    	        if (change == money) num + 1 else num
//    	      } else {
//    	        if (change == money) permutChange(change, remCoins.tail, num) else {
//    	          if (change > money) num else {
//    	            permutChange(change + remCoins.head, remCoins, num) + permutChange(change, remCoins.tail, 0)
//    	          }
//    	        }
//    	      }
//    	    }
}
