public class CoinChange {
	public static void main(java.lang.String[] args) {
		int amount = 12;
		int[] coins = new int[]{ 2, 4, 5 };
		java.lang.System.out.println((("Number of combinations of getting change for " + amount) + " is: ") + com.thealgorithms.dynamicprogramming.CoinChange.change(coins, amount));
		java.lang.System.out.println((("Minimum number of coins required for amount :" + amount) + " is: ") + com.thealgorithms.dynamicprogramming.CoinChange.minimumCoins(coins, amount));
	}

	public static int change(int[] coins, int amount) {
		int[] combinations = new int[amount + 1];
		combinations[0] = 1;
		for (int coin : coins) {
			for (int i = coin; i < (amount + 1); i++) {
				combinations[i] += combinations[i - coin];
			}
		}
		return combinations[amount];
	}

	public static int minimumCoins(int[] coins, int amount) {
		int[] minimumCoins = new int[amount + 1];
		minimumCoins[0] = 0;
		for (int i = 1; i <= amount; i++) {
			minimumCoins[i] = java.lang.Integer.MAX_VALUE;
		}
		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {
				if (coin <= i) {
					int sub_res = minimumCoins[i - coin];
					if ((sub_res != java.lang.Integer.MAX_VALUE) && ((sub_res + 1) < minimumCoins[i])) {
						minimumCoins[i] = sub_res + 1;
					}
				}
			}
		}
		return minimumCoins[amount];
	}

	public static void printAmount(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			java.lang.System.out.print(arr[i] + " ");
		}
		java.lang.System.out.println();
	}
}