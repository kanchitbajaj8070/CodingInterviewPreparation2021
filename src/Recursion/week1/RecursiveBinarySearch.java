package Recursion.week1;

import java.util.Arrays;

public class RecursiveBinarySearch {
    public static void main(String[] args) {
        int[]arr=new int[]{2,44,13,5,8,76,41};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(binarySearch(arr,0,arr.length-1,41));
    }
    public static int binarySearch(int[]arr,int s, int e,int key)
    {
            if(s>e)
            {
                return -1;
            }
        int mid=s+(e-s)/2;
        if(arr[mid]==key)
            return mid;
        else if (arr[mid]>key)
            return binarySearch(arr,s,mid-1,key);
        else
            return binarySearch(arr,mid+1,e,key);
    }
}
