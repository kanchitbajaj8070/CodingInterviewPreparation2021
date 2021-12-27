package Recursion.subsetBased;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GrayCode {
    public static void main(String[] args) {
        int numOfBits = 3;
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        list.add(0);
        set.add(0);
        generateGrayCodes(numOfBits, list, set, 0);
        System.out.println(list);
    }
    private static boolean generateGrayCodes(int numOfBits, List<Integer> ans, HashSet<Integer> alreadyVisited, int state) {
        if (ans.size() == (Math.pow(2, numOfBits))) {
            if (differBYOneBit(ans.get(0), ans.get(ans.size() - 1), numOfBits)) {
                convertToBitForm(ans, numOfBits);
                System.out.println(ans);
            return true;
            }
            return false;
        }
        for (int i = 1; i <= numOfBits; i++) {
            int num = state ^ (1 << (i - 1));
            if (!alreadyVisited.contains(num)) {
                ans.add(num);
                alreadyVisited.add(num);
                if(generateGrayCodes(numOfBits, ans, alreadyVisited, num))
                    return true;
                ans.remove(ans.size() - 1);
                alreadyVisited.remove(num);
            }
        }
        return false;
    }

    static boolean differBYOneBit(int x, int y, int times) {

        int diff = 0;
        for (int i = 0; i < times; i++) {
            int xbit = x & (1);
            int ybit = y & (1);
            if (xbit != ybit)
                diff++;
            x = x >> 1;
            y = y >> 1;

        }
        return (diff == 1);
    }

    public static void convertToBitForm(List<Integer> list, int times) {
        System.out.print("[");
        for (Integer a : list) {
            String str = "";
            for (int i = 1; i <= times; i++) {
                str += (a & 1);
                a = a >> 1;
            }
            System.out.print(str + ",");
        }
        System.out.print("]");
        System.out.println();
    }

}
