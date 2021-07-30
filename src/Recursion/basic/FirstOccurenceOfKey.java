package Recursion.basic;

public class FirstOccurenceOfKey {
    public static void main(String[] args) {
        int[]arr= {1,66,42,7,31,56,73,11,42,8,7};
        System.out.println(linearSearch(arr,0,7));
        System.out.println(linearSearchLastOccurence(arr,0,7));
    }
    public static int linearSearch(int[] arr , int i , int key)
    {
        if(i==arr.length)
            return -1;
        if(arr[i]==key)
            return i;
        return linearSearch(arr,i+1,key);
    }
    public static int linearSearchLastOccurence( int[]arr, int i, int key)
    {
        if(i==arr.length)
            return -1;

        int presentAfterCurrentIndex= linearSearchLastOccurence(arr,i+1,key);
        if( presentAfterCurrentIndex==-1)
        { if( arr[i]==key)
            return i;
            else
                return -1;
        }
        else
            return presentAfterCurrentIndex;//whenever we have found some index in latter part,
        //we have to return it

    }
}
