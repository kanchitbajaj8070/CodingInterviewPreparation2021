package DynamicProgramming;

import java.util.Arrays;

public class EggDroping {
    public static void main(String[] args) {
        int n = 2;
        int k = 2;
        int[][] dp = new int[k + 1][n + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        System.out.println(eggDroppingSolutionBinarySarch(n, k, dp));
        for (int[] aa : dp)
            System.out.println(Arrays.toString(aa));
    }

    public static int eggDroppingSolution(int n,int k,int[][]dp)
    {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        if(k==1)
            return n;
        if(dp[k][n]!=-1)
            return dp[k][n];
        int min=Integer.MAX_VALUE;
        for(int floor=1;floor<=n;floor++)
        {
            int eggBreak=1+eggDroppingSolution(floor-1,k-1,dp);
            int noBreak=1+eggDroppingSolution(n-floor,k,dp);
            min=Math.min(min,Math.max(eggBreak,noBreak));
        }
        dp[k][n]=min;
        return min;
    }
    public static int eggDroppingSolutionBinarySarch(int n,int k,int[][]dp)
    {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        if(k==1)
            return n;
        if(dp[k][n]!=-1)
            return dp[k][n];
        int low=1;
        int high=n;
        int ans=Integer.MAX_VALUE;
        while(low<high)
        {
            int mid=(low+high)/2;
            int eggBreak=1+eggDroppingSolutionBinarySarch(mid-1,k-1,dp); // this is increasing function of floor
            int noBreak=1+eggDroppingSolutionBinarySarch(n-mid,k,dp);//decreasing function of flor;
            //both of ths will interesect at some value of x. that will b optimal. if no break> break ,move to right ,
            //if break > no break mov to lft.if equal thn break
           if(eggBreak>noBreak)
               high=mid-1;
           else
               low=mid+1;
               ans=Math.min(ans,Math.max(eggBreak,noBreak));//this is optimal min point
        }
        dp[k][n]=ans;
        return ans;
    }
}
