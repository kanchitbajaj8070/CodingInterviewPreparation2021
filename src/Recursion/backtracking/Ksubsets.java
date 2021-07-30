package Recursion.backtracking;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Ksubsets {
    /*Given an integer array of N elements, the task is to divide this array into K non-empty subsets such that the sum of elements in every subset is same. All elements of this array should be part of exactly one partition.
Examples:

Input : arr = [2, 1, 4, 5, 6], K = 3
Output : Yes
we can divide above array into 3 parts with equal
sum as [[2, 4], [1, 5], [6]]

Input  : arr = [2, 1, 5, 5, 6], K = 3
Output : No
It is not possible to divide above array into 3
parts with equal sum*/
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 5, 6};
        int K = 3;
        int ts = Arrays.stream(arr).sum();
        int sum = ts / K;
        //each set should have this sum
        boolean[] visisted = new boolean[arr.length];
        boolean ans = true;
        ans = partitionKSubsets(arr, visisted, 0, K, new ArrayList<Integer>(), sum, 0);
        System.out.println(ans);
    }

    private static boolean partitionKSubsets(int[] arr, boolean[] visisted, int i, int k, ArrayList<Integer> ans, int sum, int cur_sum) {
        if (k == 0)
            return true;
        if (sum == cur_sum) {
            System.out.println(ans.toString());
            ans.clear();
            return partitionKSubsets(arr, visisted, 0, k - 1, ans, sum, 0);
        }
        if (sum < 0 || i == arr.length)
            return false;
        for (int idx = i; idx < arr.length; idx++) {
            if (!visisted[idx] && (cur_sum+arr[idx])<=sum) {
                ans.add(arr[idx]);
                visisted[idx] = true;
                cur_sum=cur_sum+arr[idx];
                 if   (partitionKSubsets(arr, visisted, idx + 1, k, ans, sum, cur_sum))
                    return true;
                visisted[idx] = false;
                ans.remove(ans.size()-1);
                cur_sum-=arr[idx];//this step caused problems
                //this is required because from we are coming back to call of the same i for which we made call
            }
        }
        return false;
    }

}
