package Recursion.AlgoExpert;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static void main(String[] args) {

        List<Integer> in = new ArrayList<>();
        in.add(1);
        in.add(2);
        in.add(3);
        System.out.println(getPowerSet(in));
    }

    private static List<List<Integer>> getPowerSet(List<Integer> list) {
        if (list.size() == 0) {
            List<List<Integer>> baseCase = new ArrayList<>();
            baseCase.add(new ArrayList<>());
            return baseCase;
        }
        List<List<Integer>> answer = new ArrayList<>();
        Integer currentInteger = list.remove(0);
        List<List<Integer>> smallAns = getPowerSet(list);

        for (List<Integer> integerList : smallAns) {
            answer.add(new ArrayList<>(integerList));
            integerList.add(0, currentInteger);
            answer.add(new ArrayList<>(integerList));
        }
        return answer;
    }
}
