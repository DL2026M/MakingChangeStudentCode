/**
 * The class Making Change solves a classic problem:
 * given a set of coins, how many ways can you make change for a target amount?
 *
 * @author Zach Blick
 * @author David Lutch
 */

public class MakingChange {
    // Tabulation
    public static long countWays(int target, int[] coins) {
        long[][] coinsArray = new long[coins.length + 1][target + 1];
        for (int h = 0; h < coins.length; h++) {
            // Base cases
            coinsArray[h][0] = 1;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= target; j++) {
                long placeHolderValue;
                // Getting the value above for the exclude case
                placeHolderValue = coinsArray[i - 1][j];
                // Only includes the coin if its value is less than or equal to the remaining sum
                if (j >= coins[i - 1]) {
                    placeHolderValue += coinsArray[i][j -  coins[i - 1]];
                }
                coinsArray[i][j] = placeHolderValue;
            }
        }
        // The value in the bottom right of the table is the most amount of ways to make change given a target amount
        // and a set of coins
        return coinsArray[coins.length][target];
    }

     // Memoization
     /* public static long countWays(int target, int[] coins) {
        long[][] coinsArray = new long[target + 1][coins.length];
        return countRecursion(target, coins, coinsArray, coins.length-1);
     }

    public static long countRecursion(int leftOver, int[] coins, long[][] coinsArray, int index) {
        long sumTracker = 0;
        if (leftOver == 0) {
            return 1;
        }
        if (leftOver < 0) {
            return 0;
        }
        // Out of bounds check
        if (index < 0) {
            return 0;
        }
        if (coinsArray[leftOver][index] != 0) {
            return coinsArray[leftOver][index];
        }
        // Only runs if this place in the 2d array hasn't been checked before
        else {
            sumTracker = countRecursion((leftOver - coins[index]), coins, coinsArray, index) + countRecursion(leftOver, coins, coinsArray, index - 1);
            coinsArray[leftOver][index] = sumTracker;
        }
        return sumTracker;
    }*/
}
