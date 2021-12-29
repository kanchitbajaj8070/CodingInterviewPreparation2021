package Recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateSubsets {
    public static void main(String[] args) {

        int[] arr = {2, 5, 6};
        generateSubsets(arr, 0, new ArrayList<>());
    }

    public static void generateSubsets(int[] arr, int i, List<Integer> temp) {
        if (i == arr.length) {
            System.out.println(temp);
            return;
        }

        temp.add(arr[i]);
        generateSubsets(arr, i + 1, temp);
        temp.remove(temp.size() - 1);
        generateSubsets(arr, i + 1, temp);
    }
}
