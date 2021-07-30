package Recursion.basic;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {

        int[]a={41,2,5,6,7,11,23,341,55,9};
        quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
    public static void quickSort(int[]a,int s,int e)
    {
        if(s>=e)
            return;
        int p=partition(a,s,e);
        quickSort(a,s,p-1);
        quickSort(a,p+1,e);
    }

    private static int partition(int[] a, int s, int e) {
   int first=a[s];
   int i=s+1;
   for( int k=s+1;k<=e;k++)
   {
       if(a[k]<first)
       {
           swap(a,k,i);
           i++;
       }
   }
        swap(a,i-1,s); //swap with any element  smaller than the first element
        //because we have to take care of only partining such that smaller on
        //one side and larger on the other side
   return i;
    }


        public static void swap(int[]a,int i , int j)
        {
            int c=a[i];
            a[i]=a[j];
            a[j]=c;
        }

}
