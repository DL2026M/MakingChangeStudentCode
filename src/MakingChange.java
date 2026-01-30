/**
 * The class Making Change solves a classic problem:
 * given a set of coins, how many ways can you make change for a target amount?
 *
 * @author Zach Blick
 * @author David Lutch
 */

public class MakingChange {
    /**
     * TODO: Complete this function, countWays(), to return the number of ways to make change
     *  for any given total with any given set of coins.
     */
    public static long countWays(int target, int[] coins) {
        long sum = 0;
        long[][] coinsArray = new long[target + 1][coins.length];
        return countRecursion(target, coins, coinsArray, coins.length);

    }
    public static long countRecursion(int target, int[] coins, long[][] coinsArray, int sum) {
        long sumTracker = 0;
        if (sum == 0) {
            return 1;
        }
        if (sum < 0) {
            return 0;
        }
        // Out of bounds check
        if (target < 0) {
            return 0;
        }
        if (coinsArray[target][sum] == 0) {
           // sumTracker = countRecursion((target - coins[sum]), coins, sum, sum) + countRecursion(target, coins, sum - 1, sum);
            coinsArray[target][sum] = sumTracker;
        }
        return sumTracker;

}
