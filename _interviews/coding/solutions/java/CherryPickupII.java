/**
 * Time Complexity: O(M * N ^ 2)
 * Space Complexity: O(M * N ^ 2)
 **/
class Solution {
    public int cherryPickup(int[][] grid) {
        dp = new int[grid.length][grid[0].length][grid[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(grid, 0, 0, grid[0].length - 1);
    }

    int[][][] dp;

    int solve(int[][] grid, int x, int y1, int y2) {
        if (x < 0 || x >= grid.length || y1 < 0 || y1 >= grid[0].length || y2 < 0 || y2 >= grid[0].length) {
            return 0;
        }

        if (dp[x][y1][y2] != -1) {
            return dp[x][y1][y2];
        }

        int res = grid[x][y1];
        if (y1 != y2) {
            res += grid[x][y2];
        }

        int max = Integer.MIN_VALUE;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                max = Math.max(max, solve(grid, x + 1, y1 + i, y2 + j));
            }
        }

        res = res + max;
        dp[x][y1][y2] = res;

        return res;
    }

}