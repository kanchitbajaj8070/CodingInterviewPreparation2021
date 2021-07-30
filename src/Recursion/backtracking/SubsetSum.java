package Recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {
    public static void main(String[] args) {
        int arr[] = {15, 22, 14, 26, 32, 9, 16, 8};
        int k = 53;
       // generateSubsets(arr,k,0,new ArrayList<>());
        int weights[] = {10, 7, 5, 18, 12, 20, 15};
        int size = 35;
        //ans for above is
        /*  10   7  18
            10   5  20
            5   18  12
            20  15*/
       generateSubsets(weights,size,0,new ArrayList<>());
        System.out.println("******************");
      int  arr2[] = {1, 2, 3, 4, 5};
        int sum = 10;
        generateSubsets(arr2,sum,0,new ArrayList<>());

    }

    private static void generateSubsets(int[] arr, int k, int i, List<Integer> ans)
    {
        if(k==0) /* very important point -this should be before the invalid base case. otherwise the last element is missed*/
        {
            System.out.println(ans.toString());
            return;
        }
     if(i==arr.length||k<0)
        return;
     if(arr[i]<=k)
     {
         ans.add(arr[i]);
         generateSubsets(arr,k-arr[i],i+1,ans);
         ans.remove(ans.size()-1);
     }
         generateSubsets(arr,k,i+1,ans);
    }
}
