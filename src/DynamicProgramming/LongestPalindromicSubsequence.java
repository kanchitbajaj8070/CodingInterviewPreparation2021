package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {

        String a = "REJIORHVBI34UHRE4";
        //System.out.println(LongestPalindromicSubsequence(a,0,a.length()-1));
        int[][] dp = new int[a.length() + 1][a.length() + 1];
        for (int i = 0; i < a.length(); i++)
            dp[i][i] = 1;
        int i = 0;
        int j = 1;
        int numberOfCharsConsidered = 2;
        while (j < a.length()) {
            while (j < a.length()) {
                if (a.charAt(i) == a.charAt(j))
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                i++;
                j++;
            }
            i = 0;
            j = numberOfCharsConsidered;
            numberOfCharsConsidered++;
        }
        for (int[] temp : dp)
            System.out.println(Arrays.toString(temp));
        char[] ans = new char[dp[0][a.length() - 1]];
        int s = 0;
        int e = ans.length - 1;
        i = 0;
        j = a.length() - 1;
        while (i != j) {
            if (dp[i][j] != dp[i + 1][j] && dp[i][j] != dp[i][j - 1]) {
                ans[s] = a.charAt(i);
                ans[e] = a.charAt(j);
                s++;
                e--;
                i++;
                j--;
            } else {
                if (dp[i][j] == dp[i + 1][j]) {
                    i = i + 1;
                } else
                    j = j - 1;
                if (i == j) {
                    ans[s] = a.charAt(j);
                    break;
                }

            }


        }
        System.out.println(Arrays.toString(ans));
        System.out.println("MXIMUM PALINDROMIC SUBSTRING IS " + dp[0][a.length() - 1]);
    }

    public static int LongestPalindromicSubsequence(String a, int start, int end) {
        if (start == end)
            return 1;

        if (a.charAt(start) == a.charAt(end))
            return 2 + LongestPalindromicSubsequence(a, start + 1, end - 1);
        else
            return Math.max(LongestPalindromicSubsequence(a, start + 1, end), LongestPalindromicSubsequence(a, start, end - 1));
    }
}
