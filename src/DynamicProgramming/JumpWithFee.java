package DynamicProgramming;

public class JumpWithFee {
    public static void main(String[] args) {
        /*Example 1:

Number of stairs (n) : 6
Fee: {1,2,5,2,1,2}
Output: 3
Explanation: Starting from index '0', we can reach the top through: 0->3->top
The total fee we have to pay will be (1+2).
Example 2:

Number of stairs (n): 4
Fee: {2,3,4,5}
Output: 5
Explanation: Starting from index '0', we can reach the top through: 0->1->top
The total fee we have to pay will be (2+3).*/

        int[] a={1,2,5,2,1,2};
        int n=6;
        System.out.println(jumpsWithMinFee(a,0));
    }

    private static int jumpsWithMinFee(int[] a, int i) {
    if(i==a.length)
        return 0;
    if(i>a.length)
        return Integer.MAX_VALUE;
    int min=Integer.MAX_VALUE;
    for(int jump=1;jump<=3;jump++)
    {
        int restOfAns=jumpsWithMinFee(a,i+jump);
        if(restOfAns!=Integer.MAX_VALUE)
            min=Math.min(min,a[i]+restOfAns);
    }
    return min;

    }
}
