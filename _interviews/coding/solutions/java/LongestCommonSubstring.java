class LongestCommonSubstring {

    /*
    Code represents longest common substring .
    Given two arrays find longest common subarray.
     */
    public int findLength(int[] a, int[] b) {
        int[][] dp = new int[a.length + 1][b.length + 1];
        int max = 0;
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max;
    }

}