class Solution {

    public int numTrees(int n) {
        this.n = n;
        this.dp = new int[n + 1][n + 1];
        return recurse(1, n);
    }

    /**
     * Intuition: Since we just need to count the number of trees, we can use dp here.
     * Number of trees for n i.e. f(n) = total trees with each of the numbers as root nodes from 1 to n.
     * For a given node say 2 , total left sub tree * total right sub tree will result in total trees.
     * Total = sum[1 to n](recurse(left ) * recurse(right))
     **/
    public int calculate(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int res = 0;
            for (int j = 1; j <= i; j++) {
                res += (dp[j - 1] * dp[i - j]);
            }
            dp[i] = res;
        }

        return dp[n];
    }


    int n;
    int[][] dp;


    /**
     * Recursive dynamic programming code. Total = sum[1 to n](recurse(left ) * recurse(right))
     * Time Complexity: O(N^2)
     * Space Complexity: O(N^2)
     */
    public int recurse(int start, int end) {

        if (start >= end) {
            return 1;
        }

        System.out.println(start + ":" + end);

        if (dp[start][end] != 0) {
            return dp[start][end];
        }

        int res = 0;
        for (int i = start; i <= end; i++) {
            res += recurse(start, i - 1) * recurse(i + 1, end);
        }
        dp[start][end] = res;
        return res;
    }
}