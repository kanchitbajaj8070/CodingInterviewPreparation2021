package DynamicProgramming;

public class MCM {
    public static void main(String[] args) {
        /*Input: p[] = {40, 20, 30, 10, 30}
Output: 26000
There are 4 matrices of dimensions 40x20, 20x30, 30x10 and 10x30.
Let the input 4 matrices be A, B, C and D.  The minimum number of
multiplications are obtained by putting parenthesis in following way
(A(BC))D --> 20*30*10 + 40*20*10 + 40*10*30*/
        int[] p={40, 20};
        System.out.println(MCM(p,1,p.length-1));
    }

    private static int MCM( int[] a, int i , int j)
    { if(i>= j)
        return 0;
        int min=Integer.MAX_VALUE;
        for(int k=i;k<j;k++)
        {
            int left=MCM(a,i,k);
            int right=MCM(a,k+1,j);
            int ans=left+right+(a[i-1]*a[k]*(a[j]));
         min=Math.min(ans,min);
        }return min;
    }
}
