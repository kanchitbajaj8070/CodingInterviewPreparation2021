package DynamicProgramming;

public class LongestPalindromicSubString {

    public static final class Pair {
        int val;
        boolean b;

        Pair(int v, boolean c) {
            val = v;
            b = c;
        }

        @Override
        public String toString() {
            return "{ " + val + " , " + b + " }";
        }
    }

    public static void main(String[] args) {

        String a = "kjfnfifefiflkjkr";
        //3
        System.out.println(LongestPalindromicSubstring(a, 0, a.length() - 1));
    }

    public static int LongestPalindromicSubstring(String a, int start, int end) {
        if (start == end)
            return 1;
        if(start>end)
            return 0;
        if (a.charAt(start) == a.charAt(end)) {
         int remainingLength=(end-start+1)-2;
            int ros= LongestPalindromicSubstring(a, start + 1, end - 1);
            if(ros==remainingLength)
             return 2 +ros;
        }
            return Math.max(LongestPalindromicSubstring(a, start + 1, end), LongestPalindromicSubstring(a, start, end - 1));
    }
}
