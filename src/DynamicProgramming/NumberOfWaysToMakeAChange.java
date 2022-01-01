package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfWaysToMakeAChange {
    public static void main(String[] args) {
        int[] money = {1, 5, 10, 25};
        int amount = 10;
        System.out.println(waysToMakeChange(money, 0, amount, new ArrayList<>()));
        unboundedKnapsackSOlution(money,amount);
        oneDsolution(money,amount);
    }
    private static void oneDsolution(int [] money,int amount)
    {
        System.out.println("************1D SOLUTION *************");
        int[] ways=new int[amount+1];
        ways[0]=1;
        for(int i=0;i<money.length;i++)
        {
            for (int j=1;j<=amount;j++)
            {
                if(money[i]<=j)
                    ways[j]+=ways[j-money[i]];
            }
        }
        System.out.println(Arrays.toString(ways));
        System.out.println(ways[amount]);

    }
    public static void unboundedKnapsackSOlution(int[]money,int amount)
    {    System.out.println("************2D SOLUTION *************");
        int[][]dp=new int[money.length+1][amount+1];
        for(int i=0;i<=money.length;i++)
            dp[i][0]=1;
        for(int i=1;i<=money.length;i++)
        {
            for(int j=1;j<=amount;j++)
            {
                if(j>=money[i-1])
                    dp[i][j]=dp[i-1][j]+dp[i][j-money[i-1]];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        System.out.println(dp[money.length][amount]);

    }

    public static int waysToMakeChange(int[] coins, int i, int amount, List<Integer> ans) {
        if (amount == 0) {
            System.out.println(ans);
            return 1;
        }//use no coins , there is one way;
        if (i == coins.length || amount < 0)
            return 0;

        int includeCoin = 0;
        int excludeCoin = 0;
        if (amount >= coins[i]) {
            ans.add(coins[i]);
            includeCoin = waysToMakeChange(coins, i, amount - coins[i], ans);
            ans.remove(ans.size() - 1);
        }
        excludeCoin = waysToMakeChange(coins, i + 1, amount, ans);
        return includeCoin + excludeCoin;

    }
}
