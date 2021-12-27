package Recursion;

import java.util.Arrays;

public class RodCuttingMaximizeProfit {
    public static void main(String[] args) {
        /*Lengths: [1, 2, 3, 4, 5]
        Prices: [2, 6, 7, 10, 13]
        Rod Length: 5*/
        int[] lengths = {1, 2, 3, 4, 5};
        int[] prices = {2, 6, 7, 10, 13};
        //answer is 14
        int L = 5;
       int[]dp=new int[L+1];
       for(int l=1;l<=L;l++)
       {
           for(int i=0;i<lengths.length;i++)
           {
               if(l-lengths[i]>=0)
                   dp[l]=Math.max(dp[l],prices[i]+dp[l-lengths[i]]);
           }
       }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[L]);
        // System.out.println(solve(lengths, prices, L, 0));
    }

    private static int solve(int[] lengths, int[] prices, int length, int i) {

        if (i == prices.length || length < 0)
            return Integer.MIN_VALUE;
        if (length == 0)
            return 0;
        int max = Integer.MIN_VALUE;
        for (int index = i; index < prices.length; index++) {
            int smallAns = solve(lengths, prices, length - lengths[index], index);
            if (smallAns != Integer.MIN_VALUE) {
                max = Math.max(max, smallAns + prices[index]);
            }
        }
        return max;

    }
}
