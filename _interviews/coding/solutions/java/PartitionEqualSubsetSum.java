/**
 * Intuition: This is a variation of knapsack dp. We precompete the target sum and find the knapsack.
 * Time Complexity: O(N ^ 2) .
 * Space Complexity: O(N ^ 2).
 */
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 == 1) {
            return false;
        }
        return knapsackBoolean(nums, sum / 2);
    }

    boolean knapsackBoolean(int[] w, int c) {
        boolean[][] dp = new boolean[w.length + 1][c + 1];
        for (int i = 0; i <= w.length; i++) {
            for (int j = 0; j <= c; j++) {
                if (i == 0) {
                    dp[i][j] = false;
                }
                if (j == 0) {
                    dp[i][j] = true;
                }

                if (i > 0 && j > 0) {
                    if (w[i - 1] <= j) {
                        dp[i][j] = dp[i - 1][j - w[i - 1]] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }

            }
        }

        return dp[w.length][c];

    }

    boolean knapsack(int[] w, int c) {
        int[][] dp = new int[w.length + 1][c + 1];
        for (int i = 1; i <= w.length; i++) {
            for (int j = 1; j <= c; j++) {
                if (w[i - 1] <= j) {
                    dp[i][j] = Math.max(w[i - 1] + dp[i - 1][j - w[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[w.length][c] == c;
    }
}