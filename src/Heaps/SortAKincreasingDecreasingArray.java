package Heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortAKincreasingDecreasingArray {
    public static void main(String[] args) {
        int k = 5;
        int[] a = {57, 131, 493, 294, 221, 339, 418, 452, 442, 190, 200};
        myApproach(a, k);
    }

    private static void myApproach(int[] a, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a1,a2)->a[a1[0]]-a[a2[0]]);                                      ;
        for (int i = 0; i < a.length; i++) {
            int t1 = i;
            while (i + 1 < a.length && a[i + 1] > a[i])
                i++;
            queue.add(new int[]{t1, 1, i});
            if (i == a.length - 1)
                break;
            int t2 = i + 1;
            while (i + 1 < a.length && a[i + 1] < a[i])
                i++;
            queue.add(new int[]{i, 0, t2});
        }
        int index = 0;
        int[] ans = new int[a.length];
        while (!queue.isEmpty()) {
            ans[index] = a[queue.peek()[0]];
            int[] r = queue.remove();
            if (r[1] == 1) {
                if (r[0] + 1 <= r[2]) {
                    r[0] = 1 + r[0];
                    queue.add(r);
                }
            } else {
                if (r[0] - 1 >= r[2]) {
                    r[0] = r[0] - 1;
                    queue.add(r);
                }
            }
            index++;
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(ans));
    }

}
