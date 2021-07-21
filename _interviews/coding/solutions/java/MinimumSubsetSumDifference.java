public class MinimumSubsetSumDifference {
    public static int minSubsetSumDifference(int[] w, int n) {
        int c = 0;
        for (int i : w) {
            c += i;
        }
        int x = c;
        c = c / 2;
        int[][] dp = new int[n + 1][c + 1];
        for (int i = 1; i <= w.length; i++) {
            for (int j = 1; j <= c; j++) {
                if (w[i - 1] <= j) {
                    dp[i][j] = Math.max(w[i - 1] + dp[i - 1][j - w[i - 1]],
                            dp[i - 1][j]
                    );
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return x - 2 * dp[w.length][c];
    }

}