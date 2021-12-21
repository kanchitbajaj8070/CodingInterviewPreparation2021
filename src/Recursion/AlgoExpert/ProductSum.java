package Recursion.AlgoExpert;

import java.util.*;

public class ProductSum {
    public static void main(String[] args) {
        String s = "[5,2,[7,-1],3,[6,[-13,8],4]]";
        List<String> input = new ArrayList<>();
        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ',') {
                prev = i;
            } else if (ch == '[' || ch == ']') {
                input.add(ch + "");
                prev = i;
            } else {
                if (Character.isDigit(ch) && (i == s.length() - 1 || !Character.isDigit(s.charAt(i + 1))))
                    input.add(s.substring(prev + 1, i + 1));
            }
        }
        List<Object> modifiedInput = createInput();
        System.out.println( recusiveSolution(modifiedInput, 1));
        // stackSolution(input);

    }

    private static List<Object> createInput() {
        //  String s = "[5,2,[7,-1],3,[6,[-13,8],4]]";
        List<Object> objects = new ArrayList<>();
        objects.add(5);
        objects.add(2);
        List<Integer> arr = new ArrayList<>();
        arr.add(7);
        arr.add(-1);
        objects.add(new ArrayList<>(arr));
        objects.add(3);
        List<Object> temp = new ArrayList<>();
        temp.add(6);
        arr = new ArrayList<>();
        arr.add(-13);
        arr.add(8);
        temp.add(new ArrayList<>(arr));
        temp.add(4);
        objects.add(new ArrayList<>(temp));
       // System.out.println(objects);
        return objects;
    }

    private static int recusiveSolution(List<Object> input, int multiplier) {
        int sum = 0;
        for (int i = 0; i < input.size(); i++) {
            Object element = input.get(i);
            if ((element instanceof ArrayList)) {
                sum += recusiveSolution((List<Object>) element, multiplier + 1);
            } else
                sum += (Integer) element;
        }
        return sum * multiplier;
    }

    private static void stackSolution(List<String> input) {
        Stack<String> stack = new Stack<>();
        int openCount = 0;
        for (String k : input) {

            if (k.equalsIgnoreCase("[")) {
                stack.add(k);
                openCount++;
            } else if (k.equalsIgnoreCase("]")) {
                String top = stack.pop();
                Integer temp = 0;
                while (!stack.isEmpty() && !(top.equals("["))) {
                    temp += Integer.parseInt(top);
                    top = stack.pop();
                }
                stack.push(String.valueOf(temp * openCount));
                openCount--;
            } else {
                stack.add(k);
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += Integer.parseInt(stack.pop());
        }

        System.out.println("ANSER IS => " + ans);
    }

}
