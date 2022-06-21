import java.util.Arrays;

/**
 * This is a variation of Unbounded Knapsack DP.
 * Important points to note:
 * Initialization for dp[i][0] = 0 for all i.
 * If an element is not included it means its not included in any of the counts.
 * Note the subtle difference in code between 0/1 Knapsack vs Unbounded Knapsack.
 * Time Complexity: O(N ^ 2)
 * Space Complexit: O(N ^ 2)
 */
class Solution {
    public int coinChange(int[] w, int c) {
        int[][] dp = new int[w.length + 1][c + 1];
        for (int[] d : dp) {
            Arrays.fill(d, Integer.MAX_VALUE / 2);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= w.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= w.length; i++) {
            for (int j = 1; j <= c; j++) {
                if (w[i - 1] <= j) {
                    dp[i][j] = Math.min(1 + dp[i][j - w[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[w.length][c] == Integer.MAX_VALUE / 2 ? -1 : dp[w.length][c];
    }
}