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

        // Case where there is only 1 type of coin
        if (coins.length == 1) {
            if (target % coins[0] == 0) {
                return (target / coins[0]);
            }
            else {
                return 0;
            }
        }
        return 0;
    }
}
