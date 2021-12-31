package DynamicProgramming;

import java.util.Arrays;

public class LongestSumIncreasingSubsequence {
    /*Input: {4,1,2,6,10,1,12}
Output: 32
Explanation: The increaseing sequence is {4,6,10,12}.
Please note the difference, as the LIS is {1,2,6,10,12} which has a sum of '31'.*/
    /*Input: {-4,10,3,7,15}
Output: 25
Explanation: The increaseing sequences are {10, 15} and {3,7,15}.*/
    public static void main(String[] args) {
        int[]a= {-4,10,3,7,15,5};
        int[]dp= Arrays.copyOfRange(a,0,a.length);

        for(int i=1;i<a.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(a[j]<=a[i])
                {
                    dp[i]=Math.max(dp[i],a[i]+dp[j]);
                }
            }
        }
        System.out.println("ANSWER IS "+Arrays.stream(dp).max().getAsInt());
        System.out.println(Arrays.toString(dp));
    }
}
