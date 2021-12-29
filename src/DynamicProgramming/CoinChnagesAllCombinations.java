package DynamicProgramming;

import java.util.Arrays;

public class CoinChnagesAllCombinations {
    /*Denominations: {1,2,3}
    Total amount: 5
    Output: 5
    Explanation: There are five ways to make the change for '5', here are those ways:
      1. {1,1,1,1,1}
      2. {1,1,1,2}
      3. {1,2,2}
      4. {1,1,3}
      5. {2,3}*/
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int amount = 5;
        // System.out.println(solve(amount,a,0));
        int[][] dp = new int[a.length + 1][amount + 1];
        for(int i=0;i<=a.length;i++)
            dp[i][0]=1;
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - a[i - 1] >= 0) {
                    dp[i][j] += dp[i][j - a[i - 1]];
                }
            }
        }
        for(int[]d:dp)
            System.out.println(Arrays.toString(d));
            System.out.println(dp[a.length][amount]);
        }


    public static int solve(int amount, int[] coins, int i) {
        if (amount < 0 || i == coins.length)
            return 0;
        if (amount == 0)
            return 1;
        int ans = solve(amount, coins, i + 1);
        if (coins[i] <= amount) {
            ans += solve(amount - coins[i], coins, i);
        }
        return ans;
    }
}
