package Recursion.subsetBased;

import java.util.HashMap;
import java.util.Map;

public class PhoneKeypad {
    public static void main(String[] args) {
        Map<Integer,String> keypad=new HashMap<>();
        keypad.put(2,"ABC");
        keypad.put(3,"DEF");
        keypad.put(4,"GHI");
        keypad.put(5,"JKL");
        keypad.put(6,"MNO");
        keypad.put(7,"PQRS");
        keypad.put(8,"UVW");
        keypad.put(9,"XYZ");
        String s="23";
        generateCombinations(s,keypad,0,"");


    }

    private static void generateCombinations(String s, Map<Integer, String> keypad,
                                             int i,String ans) {
   if(i==s.length())
   {
       System.out.print(ans+"   ");
       return;
   }
   char ch=s.charAt(i);
   int no=ch-'0';
   if(no>=2&&no<=9)
   { String mapping=keypad.get(no);
       for (int j = 0; j <mapping.length() ; j++) {
           generateCombinations(s,keypad,i+1,ans+mapping.charAt(j));
       }
   }
   else//for 0,1, invalid character case
       generateCombinations(s,keypad,i+1,ans);
    }
}
