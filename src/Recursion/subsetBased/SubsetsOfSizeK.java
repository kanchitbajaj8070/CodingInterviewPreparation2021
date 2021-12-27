package Recursion.subsetBased;

import java.util.ArrayList;
import java.util.List;

public class SubsetsOfSizeK {
    public static void main(String[] args) {

        int[] arr={1,2,5,6,9};
        SubsetsOfSizeK(arr.length,3,0,arr,new ArrayList<>());
    }
    public static void SubsetsOfSizeK(int n, int k, int i, int[]arr, List<Integer> ans)
    {
        if(k==0)
        {
            System.out.println(ans);
            return;
        }
        for(int j=i;j<=n-1;j++)
        {
            ans.add(arr[j]);
            SubsetsOfSizeK(n,k-1,j+1,arr,ans);
            ans.remove(ans.size()-1);
        }
    }

}
