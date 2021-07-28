/**
 * Intuition: This is a 0/1 knapsack dp. This is equivalent to given an array of numbers, count the
 * number of subsets whose sum of elements is = (arraySum + target) / 2. Here all the elemenets
 * with + sign can be considered as grouped into subset1 and all elements of - sign are grouped into subset2.
 * One thing to note is that if the arraySum + target is odd it means we cannot divide the array into two halfs
 * with that sum.
 * <p>
 * Time Complexity: O(N ^ 2)
 * Space Complexity: O(N ^ 2)
 **/
class Solution {
    public int findTargetSumWays(int[] a, int target) {
        int sum = 0;
        int zeros = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                zeros++;
            } else {
                sum += a[i];
            }
        }

        int[] w = new int[a.length - zeros];
        int k = 0;
        for (int i : a) {
            if (i != 0) {
                w[k++] = i;
            }
        }

        int c = sum + target;
        if (c % 2 == 1) {
            return 0;
        }

        c = c / 2;


        int[][] dp = new int[w.length + 1][c + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (w[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - w[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

//         for(int d[] : dp) {
//             System.out.println(Arrays.toString(d));
//         }

        return dp[w.length][c] * (int) Math.pow(2, zeros);

    }
}