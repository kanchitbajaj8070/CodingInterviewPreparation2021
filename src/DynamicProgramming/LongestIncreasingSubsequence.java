package DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        /*Input: {4,2,3,6,10,1,12}
Output: 5
Explanation: The LIS is {2,3,6,10,12}.*/
        int[]a={4,2,3,6,10,1,12,7};
        int max=0;
        for(int i=0;i<a.length;i++)
        max=Math.max(max,LIS(a,i));
        System.out.println(max);
        System.out.println(LISDP(a));
    }
    public static int LISDP(int[]a)
    {
        int[]dp=new int[a.length];
        Arrays.fill(dp,1);
        for(int i=1;i<a.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(a[j]<=a[i])
                    dp[i]=Math.max(dp[i],1+dp[j]);
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
    public static int LIS(int[]a,int i)
    { if(i==a.length)
            return 0;
        int max=0;
        for(int j=i+1;j<a.length;j++)
        { if(a[j]>a[i])
            { int ans=LIS(a,j);
                max=Math.max(max,ans);
            }
        }
return max+1;
    }
}
