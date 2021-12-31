package DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubsequnce {
    public static void main(String[] args) {
        String s1 = "passport";
        String s2 = "ppsspt";
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int max = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                max = Math.max(max, dp[i][j]);
            }

        }
        for (int[] d : dp)
            System.out.println(Arrays.toString(d));
    }
}
