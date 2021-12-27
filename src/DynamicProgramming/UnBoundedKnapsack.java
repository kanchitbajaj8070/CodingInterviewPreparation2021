package DynamicProgramming;

import java.util.Arrays;

public class UnBoundedKnapsack {
    public static void main(String[] args) {
        int[] profits = {15, 50, 60, 70};
        int[] weights = {1, 3, 4, 5};
        int W=5;
        int[][]dp=new int[profits.length+1][W+1];
        for(int i=1;i<=profits.length;i++)
        {
            for(int j=1;j<=W;j++)
            {
                if(weights[i-1]<=j)
                {
                    dp[i][j]=Math.max(dp[i-1][j],profits[i-1]+dp[i][j-weights[i-1]]);
                }
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        for(int[]d:dp)
            System.out.println(Arrays.toString(d));
        System.out.println(dp[profits.length][W]);
    }
}
