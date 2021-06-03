package Recursion.week1;

import java.util.Arrays;

public class InversionCount {
    public static void main(String[] args) {
    int[]a={1,5,2,6,3,0};
        System.out.println(inversionCount(a,0,a.length-1));
        System.out.println(Arrays.toString(a));
    //a[i]>a[j} where i> j ; all such pairs
        //[1,5,2]=1
        //[6,3,0]=3
        //[1,2,5] , [0,3,6] =>3+1=4 ( called cross inversions )
        //total 8 wich is ans
    }
    public static int inversionCount(int[]a,int s , int e)
    {
        if(s>=e)
            return 0;
        int mid=(e+s)/2;
        int count1=inversionCount(a,s,mid);
        int count2=inversionCount(a,mid+1,e);
        int combine=merge(a,s,mid,e);
        return count1+count2+combine;
    }

    private static int merge(int[] a, int s, int mid, int e) {

    int leftLength=mid-s+1;
    int rightLength=e-mid;
    int[]left= new int[leftLength];
    int []right= new int[rightLength];
    int li=0;
    int ri=0;
    for(int i=s;i<=mid;i++)
        left[li++]=a[i];
    for( int i=mid+1;i<=e;i++)
        right[ri++]=a[i];
    li=0;
    ri=0;
    int mi=s;
    int ans=0;
    while(li<leftLength&&ri<rightLength)
    {
        if(left[li]<right[ri])
            a[mi++]=left[li++];
        else
        {
            ans+=(leftLength-li);
            a[mi++]=right[ri++];
        }
    }

    while(li<leftLength)
    {
    a[mi++]=left[li++];
    }
    while(ri<rightLength)
        a[mi++]=right[ri++];
    return ans;

    }

}
