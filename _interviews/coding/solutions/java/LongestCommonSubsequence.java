class LongestCommonSubsequence {

    Integer[][] dp;

    public int longestCommonSubsequence(String s1, String s2) {
        return lcsIterative(s1, s2);

        // dp = new Integer[s1.length()][s2.length()];
        // return lcs(s1, s2, 0, 0);
    }

    //Dynamic Programming Iterative approach.
    int lcsIterative(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    int lcs(String s1, String s2, int n, int m) {
        if (n == s1.length() || m == s2.length()) {
            return 0;
        }

        if (dp[n][m] != null) {
            return dp[n][m];
        }

        int res = 0;
        if (s1.charAt(n) == s2.charAt(m)) {
            res = 1 + lcs(s1, s2, n + 1, m + 1);
        } else {
            res = Math.max(lcs(s1, s2, n + 1, m), lcs(s1, s2, n, m + 1));
        }

        dp[n][m] = res;
        return res;
    }


}