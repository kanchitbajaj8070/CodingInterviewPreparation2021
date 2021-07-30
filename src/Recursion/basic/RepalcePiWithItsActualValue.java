package Recursion.basic;

public class RepalcePiWithItsActualValue {
    public static void main(String[] args) {
        String a="xipioiuishdipiawpi";
        StringBuilder b=new StringBuilder();
        replacePi(a,0,b);
        System.out.println(b.toString());
    }
    public static void replacePi( String a, int i, StringBuilder newans)
    {
        if(i<a.length()-1)
        {
            char first=a.charAt(i);
            char second=a.charAt(i+1);
            if(first=='p'&&second=='i')
            {
                newans.append("3.14");
                replacePi(a,i+2,newans);
            }
            else
            {
                newans.append(first);
                replacePi(a,i+1,newans);
            }
        }
    }
}
