package Recursion.subsetBased;

public class GenerateStringsFromNumbers {
    public static void main(String[] args) {
        int[] no={1,2,1,2};
        //1-A, 2-B, so on
        generateStringsFromNumbers(no,"",0);
    }

    private static void generateStringsFromNumbers(int[] no, String s, int i) {
    if(i==no.length)
    {
        System.out.print(s+"    ");
        return;
    }
    int first=no[i];
    int second=(i==no.length-1)?-1:no[i+1];
    char chFirst=(char)(first-1+'A');
    generateStringsFromNumbers(no,s+chFirst,i+1);
    if(second!=-1&&((first*10+second)<=26))
    { char chSecond=(char)(((first*10+second)-1)+'A');
        generateStringsFromNumbers(no,s+chSecond,i+2);
    }
    }
}
