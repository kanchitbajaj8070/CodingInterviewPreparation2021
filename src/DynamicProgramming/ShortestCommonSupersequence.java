package DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ShortestCommonSupersequence {
    public static void main(String[] args) {
      /*Input: s1: "dynamic" s2:"programming"
Output: 15
Explanation: The SCS is "dynprogrammicng".
Input: s1: "abcf" s2:"bdcf"
Output: 5
Explanation: The shortest common super-sequence (SCS) is "abdcf".*/
        String s1 = "dynamic";
        String s2 = "programming";
        int lcs = computeLCS(s1, s2);
        System.out.println(lcs);
        System.out.println(s1.length() + s2.length() - lcs);
    }

    private static int computeLCS(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        for (int[] d : dp)
            System.out.println(Arrays.toString(d));
        StringBuilder sb = new StringBuilder();
        int i = s1.length();
        int j = s2.length();
        while (i >= 1 && j >= 1) {
            if (dp[i][j] == dp[i - 1][j])
                i--;
            else if (dp[i][j] == dp[i][j - 1])
                j--;
            else {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            }
        }
        System.out.println(sb.reverse().toString());
        return dp[s1.length()][s2.length()];
    }
}
