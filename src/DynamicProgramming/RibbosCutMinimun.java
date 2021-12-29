package DynamicProgramming;

import java.util.Arrays;

public class RibbosCutMinimun {
    public static void main(String[] args) {
        /*n: 7
Ribbon Lengths: {2,3}
Output: 3
Explanation: Ribbon pieces will be {2,2,3}.*/
    int[] a={2,3};
    int l=91;

    int ans=minCutsRibbon(a,0,l);
    if(ans==Integer.MAX_VALUE)
        System.out.println("-1");
    else
        System.out.println(ans);

        int[][]dp=new int[a.length+1][l+1];
        for(int[]d:dp)
        Arrays.fill(d,Integer.MAX_VALUE);
        for(int i=0;i<=a.length;i++)
            dp[i][0]=0;
        for(int i=1;i<=a.length;i++)
        {
            for(int j=1;j<=l;j++)
            {

                if(a[i-1]<=j&&dp[i][j-a[i-1]]!=Integer.MAX_VALUE)
                dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-a[i-1]]);
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        System.out.println(dp[a.length][l]);
        System.out.println("=++========================");
        for(int[]d:dp)
            System.out.println(Arrays.toString(d));
    }
    private static int minCutsRibbon(int[]a,int i,int l)
    {
        if(l<0||i==a.length)
            return Integer.MAX_VALUE;
        if(l==0)
            return 0;
        int min=Integer.MAX_VALUE;
    for(int index=i;index<a.length;index++)
    {
        int makeCut=minCutsRibbon(a,index,l-a[index]);
        if(makeCut!=Integer.MAX_VALUE)
            min=Math.min(min,1+makeCut);
    }
    return min;
    }
}
