package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumSubsetSumNoTwoAdjancent {
    public static void main(String[] args) {
        int[]a ={7,10,12,7,9,14};//ans is 33(7+12+!4)
        List<Integer> ans=new ArrayList<>();
        System.out.println(maximumSubsetSumNoTwoAdjancentRecursive(a,0,ans));
        int[] dp=new int[a.length+1];
        dp[1]=a[0];
        for(int i=2;i<=a.length;i++)
        {
            dp[i]=Math.max(dp[i-1],dp[i-2]+a[i-1]);
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[a.length]);
    }
    public static int maximumSubsetSumNoTwoAdjancentRecursive(int[]a,int i,List<Integer> ans)
    {

        if(i>=a.length) {
            System.out.println(ans);
            return 0;
        }
            int exc=maximumSubsetSumNoTwoAdjancentRecursive(a,i+1,ans);
            ans.add(a[i]);
            int inc=maximumSubsetSumNoTwoAdjancentRecursive(a,i+2,ans)+a[i];
            ans.remove(ans.size()-1);

            return Math.max(inc,exc);
    }

}
