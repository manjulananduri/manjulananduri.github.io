public class SubsetSumWithTarget {

    static boolean checkIfSubsetExistsWithTargetSum(int[] w, int c) {
        boolean[][] dp = new boolean[w.length + 1][c + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= w.length; i++) {
            for (int j = 1; j <= c; j++) {
                if (w[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - w[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[w.length][c];
    }

    public static void main(String[] args) {
        int[] w = {3, 34, 4, 12, 5, 2};
        int c = 9;
        System.out.println(checkIfSubsetExistsWithTargetSum(w, c));

        int[] w1 = {3, 34, 4, 12, 5, 2};
        int c1 = 13;
        System.out.println(checkIfSubsetExistsWithTargetSum(w1, c1));
    }
}