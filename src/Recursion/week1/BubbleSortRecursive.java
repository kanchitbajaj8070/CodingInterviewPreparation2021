package Recursion.week1;

import java.util.Arrays;

public class BubbleSortRecursive {
    public static void main(String[] args) {
        int[]a={41,2,5,6,7,11,23,341,55,9};
        bubbleSortRecursiveNoLoop(a,0,a.length);
        System.out.println(Arrays.toString(a));
    }
    public static void bubbleSort( int []a, int i,int n)
    {
        if(i==n)
            return;

        for( int j=1;j<n-i;j++)
        {
            if(a[j-1]>a[j])
            {
                swap(a,j,j-1);
            }
        }

        bubbleSort(a,i+1,n);

    }
    public static void swap(int[]a,int i , int j)
    {
        int c=a[i];
        a[i]=a[j];
        a[j]=c;
    }
    public static void bubbleSortRecursiveNoLoop( int[]a, int i , int n)
    {
        if( n==1)
            return;

        if(i==n-1)//last index of current array
        {//call for the smaller array by reducing size
            //think of this as a means of imposing outer loop of iterative code
        bubbleSortRecursiveNoLoop(a,0,n-1);
        return;
        }
//( think of the rest one as an inner loop only);
        if(a[i]>a[i+1])
        {
            swap(a,i,i+1);
        }

        bubbleSortRecursiveNoLoop(a,i+1,n);

    }
}
