package DynamicProgramming;

import java.util.Arrays;

public class LongestBiotonicSubsquence {
    public static void main(String[] args) {
        int[]a={4,2,3,6,10,1,12,11,9,7};
        int[] lis=new int[a.length];
        int[] lds=new int[a.length];
        Arrays.fill(lis,1);
        Arrays.fill(lds,1);
    for(int i=1;i<a.length;i++)
    {
        for(int j=0;j<i;j++)
        {
            if(a[j]<=a[i])
                lis[i]=Math.max(lis[i],1+lis[j]);
        }
    }
        for(int i=a.length-1;i>=0;i--)
        {
            for(int j=a.length-1;j>i;j--)
            {
                if(a[i]>=a[j])
                    lds[i]=Math.max(lds[i],1+lds[j]);
            }
        }
        System.out.println(Arrays.toString(lis));
        System.out.println(Arrays.toString(lds));
        int[] biotinic=new int[a.length];
        for (int i = 0; i < a.length; i++) {
            biotinic[i]=lds[i]+lis[i]-1;
        }
        System.out.println(Arrays.stream(biotinic).max().getAsInt());

    }
}
