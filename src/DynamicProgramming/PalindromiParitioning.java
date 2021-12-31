package DynamicProgramming;

import java.util.Arrays;

public class PalindromiParitioning {
    public static void main(String[] args) {
        /*Input: "abdbca"
    Output: 3
    Explanation: Palindrome pieces are "a", "bdb", "c", "a".*/
        String s = "abdrfbbrvrb45h34554trgrttrh6jyjerktykkyfdbfdnttykytdfbfdbjhgjg,d,x,ty,tykytca";

        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        long sr = System.currentTimeMillis();
        System.out.println(palindromicPartioning(s, 0) - 1);
        long er = System.currentTimeMillis();
        System.out.println("Time Taken in recusriosn is "+(er-sr));
        System.out.println(palindromicPartioningMemo(s, 0, dp) - 1);
        System.out.println("Time Taken in Memo is "+(System.currentTimeMillis()-er));
    }

    public static int palindromicPartioning(String s, int i) {
        if (i == s.length())
            return 0;
        int minParition = Integer.MAX_VALUE;
        for (int j = i + 1; j <= s.length(); j++) {
            if (isPalin(s.substring(i, j))) {
                int ans = palindromicPartioning(s, j);
                if (ans != Integer.MAX_VALUE)
                    minParition = Math.min(1 + ans, minParition);
            }

        }
        return minParition;
    }

    public static int palindromicPartioningMemo(String s, int i, int[] dp) {
        if (i == s.length())
            return 0;
        if (dp[i] != -1)
            return dp[i];
        int minParition = Integer.MAX_VALUE;
        for (int j = i + 1; j <= s.length(); j++) {
            if (isPalin(s.substring(i, j))) {
                int ans = palindromicPartioningMemo(s, j, dp);
                if (ans != Integer.MAX_VALUE)
                    minParition = Math.min(1 + ans, minParition);
            }

        }
        dp[i] = minParition;
        return minParition;
    }

    private static boolean isPalin(String a) {
        return new StringBuilder(a).reverse().toString().equalsIgnoreCase(a);
    }
}
