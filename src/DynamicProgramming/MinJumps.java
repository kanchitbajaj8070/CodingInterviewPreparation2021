package DynamicProgramming;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinJumps {
    public static void main(String[] args) {
        /*Input = {1,1,3,6,9,3,0,1,3}
Output = 4
Explanation: Starting from index '0', we can reach the last index through: 0->1->2->3->8*/
        int[] a = {1, 1, 2, 0, 2, 0, 3, 0, 0};
        List<Integer> ans = new ArrayList<>();
        System.out.println(minJumps(a, 0, ans));
        int[] dp = new int[a.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] != 0 && dp[j] != Integer.MAX_VALUE && a[j] + j >= i)
                    dp[i] = Math.min(dp[i], 1 + dp[j]);
            }
        }
        System.out.println(Arrays.toString(dp));
    }

    private static int minJumps(int[] a, int i, List<Integer> ans) {


        if (i >= a.length-1) {
            System.out.println(ans);
            return 0;
        }
        if ( a[i] == 0)
            return Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        ans.add(i);
        for (int k = 1; k <= a[i]; k++) {
            if(i+k>=a.length)
                break;
            int smallAns = minJumps(a, i + k, ans);
            if (smallAns != Integer.MAX_VALUE)
                min = Math.min(min, 1 + smallAns);
        }
        ans.remove(ans.size() - 1);
        return min;
    }
}
