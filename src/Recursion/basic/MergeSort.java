package Recursion.basic;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[]a={41,2,5,6,7,11,23,341,55,9,13};
mergeSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
    public static void mergeSort( int []a, int s, int e)
    {
        if(s>=e)
            return;
        int mid=(e+s)/2;
        mergeSort(a,s,mid);
        mergeSort(a,mid+1,e);
        merge(a,s,mid,e);
    }

    private static void merge(int[] a, int s, int mid, int e) {

   int leftLength=mid-s+1;
   int rightLength=e-mid;
   int[]left=new int[leftLength];
   int[]right=new int[rightLength];

   int li=0;//left index
   int ri=0;//right index;
   //creating copies of element
   for( int i=s;i<=mid;i++)
       left[li++]=a[i];
   for(int j=mid+1;j<=e;j++)
       right[ri++]=a[j];
   int mi=s;//main array index
   li=0;
   ri=0;
   while(li<leftLength&&ri<rightLength)
   {
       if( left[li]>right[ri] ) {
           a[mi] = right[ri];
           ri++;
       }
       else {
           a[mi] =left[li];
       li++;
       }
       mi++;
   }
   while(li<leftLength)
   {
       a[mi]=left[li];
       li++;
       mi++;
   }
   while(ri<rightLength)
   {
       a[mi]=right[ri];
       mi++;
       ri++;
   }

    }
    public static void swap(int[]a,int i , int j)
    {
        int c=a[i];
        a[i]=a[j];
        a[j]=c;
    }


}
