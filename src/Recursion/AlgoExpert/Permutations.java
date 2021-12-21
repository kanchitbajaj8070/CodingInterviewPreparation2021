package Recursion.AlgoExpert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        //System.out.println(getAllPermutations("abc"));
        List<Integer> in = new ArrayList<>();
        in.add(1);
        in.add(2);
        in.add(3);
      //  System.out.println(getAllPermutations(in));
        System.out.println(getAllPermutationBySwap(in,0));
    }

    public static List<String> getAllPermutations(String str) {
        if (str.isEmpty()) {
            List<String> baseCase = new ArrayList<>();
            baseCase.add("");
            return baseCase;
        }
        List<String> answer = new ArrayList<>();
        char currentCharacter = str.charAt(0);
        List<String> permutaionForRemainingString = getAllPermutations(str.substring(1));
        for (String s : permutaionForRemainingString) {
            for (int i = 0; i <= s.length(); i++) {
                answer.add(s.substring(0, i) + currentCharacter + s.substring(i));
            }
        }
        //Collections.sort(answer);
        return answer;
    }

    public static List<List<Integer>> getAllPermutations(List<Integer> list) {
        if (list.size() == 0) {
            List<List<Integer>> baseCase = new ArrayList<>();
            baseCase.add(new ArrayList<>());
            return baseCase;
        }
        List<List<Integer>> answer = new ArrayList<>();
        Integer currentInteger = list.remove(0);
        List<List<Integer>> smallAns = getAllPermutations(list);
        for (List<Integer> smallList : smallAns) {
            for (int i = 0; i <= smallList.size(); i++) {
                List<Integer> l = new ArrayList<>(smallList);
                l.add(i, currentInteger);
                answer.add(new ArrayList<>(l));
            }
        }
        return answer;
    }
    public static void swap(List<Integer> list,int i, int j)
    {
        Integer temp=list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    }
    private static List<List<Integer>> getAllPermutationBySwap(List<Integer> list,int indexToSwap)
    {
        if(indexToSwap==list.size()){
            List<List<Integer>> baseCase = new ArrayList<>();
            baseCase.add(new ArrayList<>(list));
            return baseCase;
        }
        List<List<Integer>> answer = new ArrayList<>();
        for(int j=indexToSwap;j<list.size();j++)
        {
            swap(list,indexToSwap,j);
            List<List<Integer>> rrAns=getAllPermutationBySwap(list,indexToSwap+1);
            swap(list,indexToSwap,j);
            answer.addAll(rrAns);
        }
        return answer;
    }
}
