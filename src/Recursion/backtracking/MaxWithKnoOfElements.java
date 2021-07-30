package Recursion.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxWithKnoOfElements {
    /*
    * Given a set of n integers, divide the set in two subsets of n/2 sizes each such that the difference of the sum of two subsets is as minimum as possible. If n is even, then sizes of two subsets must be strictly n/2 and if n is odd, then size of one subset must be (n-1)/2 and size of other subset must be (n+1)/2.*/

    public static class Pair
    {
        int sum;
        List<Integer> ans;
        Pair(int a, List<Integer> b)
        {
            sum=a;
            ans=new ArrayList<>(b);
        }
        @Override
        public String toString()
        {
            return "(Sum = "+ sum+"  ,List = "+ans.toString()+" )";
        }
    }

    public static void main(String[] args) {
        int  arr[] =  {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
        //{1, 2, 3, 4, 5};
        List<Integer> finalans=new ArrayList<>();
        System.out.println(maxSumWithKElements(arr,3,0,new ArrayList<>(),0,finalans));
        System.out.println(finalans);
    }
    public static int  maxSumWithKElements(int[]arr, int k, int i, List<Integer> ans,int sum,
                                           List<Integer> finalans)
    { if(k==0)
        {
            System.out.println(ans.toString()+"," +sum);
            int sum_cur=0;
            for(int e:finalans)
                sum_cur+=e;
            if(sum>sum_cur) {
                finalans.clear();
                ans.forEach(e -> finalans.add(e));
            }
            return sum;
        }
        if(i==arr.length||k<=0)
        {
            return 0;
        }

        ans.add(arr[i]);
        int included=maxSumWithKElements(arr,k-1,i+1,ans,sum+arr[i],finalans);
        ans.remove(ans.size()-1);
        int excluded=maxSumWithKElements(arr,k,i+1,ans,sum,finalans);
        return Math.max(included,excluded);
    }
}
