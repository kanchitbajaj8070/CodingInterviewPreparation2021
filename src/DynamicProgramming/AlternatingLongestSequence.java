package DynamicProgramming;

public class AlternatingLongestSequence {
    /*Input: {3,2,1,4}
Output: 3
Explanation: The LAS are {3,2,4} and {2,1,4}.*/
    /*Input: {1,3,2,4}
Output: 4
Explanation: The LAS is {1,3,2,4}.
Input: {1,2,3,4}
Output: 2
Explanation: There are many LAS: {1,2}, {3,4}, {1,3}, {1,4}
*/
    public static void main(String[] args) {
        int[] a={1,3,2,4,8,83,23,13,4,1,4,145,6,3};
        System.out.println(Math.max(solveRecusrive(a,0,true,Integer.MAX_VALUE),solveRecusrive(a,0,false,Integer.MIN_VALUE)));
        System.out.println(dpSOlutionOnFromLeetcode(a));
    }
    public static int dpSOlutionOnFromLeetcode(int[]a)
    {
        int n=a.length;
        int[] maxLengthEndingWithUpWiggle=new int[n];
        int[] maxLengthEndingWithDownWiggle=new int[n];


        maxLengthEndingWithUpWiggle[0]=1;
        maxLengthEndingWithDownWiggle[0]=1;
        //all element will be included in answer if they are alternating ,

        for(int i=1;i<n;i++)
        {
            if(a[i]>a[i-1])
            {
                maxLengthEndingWithUpWiggle[i]=1+maxLengthEndingWithDownWiggle[i-1];
                maxLengthEndingWithDownWiggle[i]=maxLengthEndingWithDownWiggle[i-1];
            }
            else if(a[i]<a[i-1])
            {
                maxLengthEndingWithDownWiggle[i]=1+maxLengthEndingWithUpWiggle[i-1];
                maxLengthEndingWithUpWiggle[i]=maxLengthEndingWithUpWiggle[i-1];
            }
            else
            {
                maxLengthEndingWithDownWiggle[i]=maxLengthEndingWithDownWiggle[i-1];
                maxLengthEndingWithUpWiggle[i]=maxLengthEndingWithUpWiggle[i-1];
            }
        }
        return Math.max(maxLengthEndingWithUpWiggle[n-1],maxLengthEndingWithDownWiggle[n-1]);
}
    //b==true the currenct<prev
    //b==false then current>pre
    private static int solveRecusrive(int[]a,int i, boolean b,int prev)
    {
        if(i==a.length)
            return 0;
        int c1=0;
        int c2=0;
        int c3=0;
        c1=solveRecusrive(a,i+1,b,prev);
        if(b&&a[i]<prev)
        c2= 1+solveRecusrive(a,i+1,false,a[i]);
        if(!b&&a[i]>prev)
            c3=1+solveRecusrive(a,i+1,true,a[i]);
        return Math.max(Math.max(c1,c2),c3);
    }
}
