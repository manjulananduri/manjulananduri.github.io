import java.util.Arrays;

public class CountOfSubsetsWithGivenDifferencebetweensubsets {

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 3};
        int diff = 1;
        System.out.println(countSubsetsWithDiff(a, diff));
    }

    static int countSubsetsWithDiff(int[] a, int diff) {
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        int c = (diff + sum);
        if (c % 2 == 1) {
            return 0;
        }
        c = c / 2;

        int[][] dp = new int[c + 1][a.length + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0) {
                    dp[i][j] = 1;
                    continue;
                }

                if (j == 0) {
                    continue;
                }

                if (a[j - 1] <= i) {
                    dp[i][j] = dp[i - a[j - 1]][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

//        for(int[] d : dp) {
//            System.out.println(Arrays.toString(d));
//        }

        return dp[c][a.length];
    }

}