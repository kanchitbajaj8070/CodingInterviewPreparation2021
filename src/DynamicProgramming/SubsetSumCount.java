package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class SubsetSumCount {
    /*Input: {1, 2, 7, 1, 5}, S=9
Output: 3
The given set has '3' subsets whose sum is '9': {2, 7}, {1, 7, 1}, {1, 2, 1, 5}
*     */
    public static void main(String[] args) {
        int [] a={1,2,7,1,5};
        int k=9;
        System.out.println(countSubsetsWithSumKDPaPPROACH(k,a));
        System.out.println(countSubsetsWithSumK(k,a,0,new ArrayList<>()));

    }
    static int countSubsetsWithSumK(int k, int [] a, int i, List<Integer> l)
    {
        if(k==0) {
            System.out.println(l);
            return 1;
        }
        if(k<0||i==a.length)
            return 0;
        int ans=countSubsetsWithSumK(k,a,i+1,l);
        if(a[i]<=k)
        {
            l.add(a[i]);
            ans+=countSubsetsWithSumK(k-a[i],a,i+1,l);
        l.remove(l.size()-1);
        }

    return ans;
    }
    static int countSubsetsWithSumKDPaPPROACH(int k, int [] a) {
    int[]dp=new int[k+1];
    dp[0]=1;
    for(int i=0;i<a.length;i++)
    { for(int sum=k;sum>=0;sum--)
        { if(sum-a[i]>=0)
            dp[sum]+=dp[sum-a[i]];
        }
    }
    return dp[k];
    }
}

