package DynamicProgramming;

import java.util.Arrays;

public class SubsequenceMatching {
    /*Input:
string a = "GeeksforGeeks"
string b = "Gks"

Output: 4

Explanation:
The four strings are - (Check characters marked in bold)
GeeksforGeeks
GeeksforGeeks
GeeksforGeeks
GeeksforGeeks*/
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        String pattern = "gks";
        int[][] dp = new int[str.length() + 1][pattern.length() + 1];
        int[]times=new int[pattern.length()];
        for(int i=0;i<=str.length();i++)
            dp[i][0]=1;//if paatern is empty there is one way to match
        for (int i = 1; i <= str.length(); i++)
        {
            for(int j=1;j<=pattern.length();j++)
            {

                if(str.charAt(i-1)==pattern.charAt(j-1))
                {
                        dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        for(int[]d:dp)
            System.out.println(Arrays.toString(d));

        System.out.println(recursiveSolution(str,pattern,str.length(),pattern.length()));
    }
    private static int recursiveSolution(String str,String pattern,int m, int n)
    {

        if(m==0&&n==0)//if both pattern and str both empty then also
            return 1;
        if(n==0) //if length of pattern is zero, then there is alwasy atleast one way of matching as one of the subsequnece will be ""
            return 1;
        if(m==0)
            return 0;//only first string emmty not secod
        if(str.charAt(m-1)==pattern.charAt(n-1))
            //two option - 1consider this as part of char as part of answer m-1,n-1
            //2. dont consider this s answer . recur for m-1,n
            return recursiveSolution(str,pattern,m-1,n-1)+recursiveSolution(str,pattern,m-1,n);
        else
            return recursiveSolution(str,pattern,m-1,n);


    }
}
