package strings;

public class KMP {
    public static void main(String[] args) {
        String txt = "onxonionyonion";
     String   pat = "onion";
     int n=txt.length();
     int m=pat.length();
     int[] lps=new int[m];
    fillLps(lps,pat);
    int i=0;
    int j=0;
    while(i<n)
    {
        if(txt.charAt(i)==pat.charAt(j))
        {
            i++;
            j++;
        }
        else
        {
            if(j==0)//missmatch at first character onyl
                i++;
            else
                j=lps[j-1];
        }
        if(j==m)
        {
            System.out.println("found pattern ar index : "+ (i-j));
            j=lps[j-1];
        }
    }
    }
    static void fillLps(int[] lps,String pat)
    {
        int len=0;
        int i=1;
        while(i<pat.length())
        {
            if(pat.charAt(len)==pat.charAt(i))
            {
                lps[i]=len+1;
                len++;
                i++;
            }
            else
            {
                if(len==0) {
                    lps[i] = 0;
                    i++;
                }
                else {
                    len = lps[len - 1];
                }
            }



        }
    }


}
