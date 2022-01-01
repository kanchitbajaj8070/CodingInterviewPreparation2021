package DynamicProgramming;

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {

        String s2 = "sunday";
        String s1 = "saturday";
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        System.out.println(editDistanceRecursive(s1, s2, s1.length(), s2.length(), dp));
        dpSolution(s1, s2);
    }

    private static int editDistanceRecursive(String str1, String str2, int m, int n, int[][] dp) {
        if (m == 0 && n == 0)
            return 0;
        if (m == 0)
            return n;
        if (n == 0)
            return m;
        if (dp[m][n] != -1)
            return dp[m][n];
        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            return dp[m][n] = editDistanceRecursive(str1, str2, m - 1, n - 1, dp);
        else {
            int replace = 1 + editDistanceRecursive(str1, str2, m - 1, n - 1, dp);
            int insert = 1 + editDistanceRecursive(str1, str2, m, n - 1, dp);
            int delete = 1 + editDistanceRecursive(str1, str2, m - 1, n, dp);
            return dp[m][n] = Math.min(Math.min(insert, delete), replace);
        }
    }

    private static void dpSolution(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            dp[i][0] = i;
        for (int i = 1; i <= n; i++)
            dp[0][i] = i;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                }
            }
        }
        for (int[] d : dp)
            System.out.println(Arrays.toString(d));
        int i=m;
        int j=n;
        String[] instructions=new String[dp[m][n]];
        int k=instructions.length-1;
        while(i>=1&&j>=1)
        {
            if(str1.charAt(i-1)==str2.charAt(j-1))
            {
                i--;
                j--;
            continue;
            }
            int val=dp[i][j];
            int rep=dp[i-1][j-1];
            int ins=dp[i][j-1];
            int del=dp[i-1][j];
            if(val==1+rep)
            {
                instructions[k]="REPLACE "+str1.charAt(i-1)+" in string1 with "+str2.charAt(j-1)+" . ";
                i--;
                j--;
            }
            else if(val==1+ins)
            {
                instructions[k]="INSERT "+str2.charAt(j-1)+" in string1";
                j--;
            }
            else
            {
                instructions[k]="DELTETE "+str1.charAt(i-1)+" from string1.";
                i--;
            }
            k--;
        }

        for(String s:instructions)
            System.out.println(s);
    }
}
