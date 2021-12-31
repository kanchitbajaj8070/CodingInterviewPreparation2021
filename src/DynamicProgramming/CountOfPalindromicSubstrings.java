package DynamicProgramming;

import java.util.Arrays;

public class CountOfPalindromicSubstrings {
    public static void main(String[] args) {

        String s = "cddpd";
        int n = s.length();
        boolean[][] dp = new boolean[n + 1][n];
        for (int i = 0; i < n; i++)
            dp[i][i] = true;
        for (int i = 0; i < n; i++)
            dp[n][i] = true;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1))
                dp[i - 1][i] = true;
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (dp[i + 1][j - 1]&&s.charAt(i)==s.charAt(j))
                    dp[i][j] = true;
            }
        }
        int count = 0;
        for (boolean[] de : dp) {
            for (int i = 0; i < de.length; i++)
                if (de[i])
                    count++;
            System.out.println(Arrays.toString(de));
        }
        System.out.println(count-s.length());// subtract from the last redudant row kept for cleaner code purposes
    }
}
