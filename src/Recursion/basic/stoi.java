package Recursion.basic;

public class stoi {
    public static void main(String[] args) {
        String a="1234";
        System.out.println(printStoI(a));
    }

    private static int printStoI(String a) {
        if(a.isEmpty())
            return 0;
        int ch=a.charAt(a.length()-1)-'0';
        int smallAns=printStoI(a.substring(0,a.length()-1));
        return smallAns*10+ch;

    }
}
