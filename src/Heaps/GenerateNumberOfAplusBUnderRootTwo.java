package Heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class GenerateNumberOfAplusBUnderRootTwo {
    //generate k smallest number of a+b&2^(.5)
    //a+ b * underRoot 2
    //0+0*1.414 =0 , 1, 1.414, 2 ,2.414 ->first 5 smallest;
    public static final class Element {
        int a;
        int b;
        float val;

        public Element(int a, int b, float val) {
            this.a = a;
            this.b = b;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Element{" +
                    "a=" + a +
                    ", b=" + b +
                    ", val=" + val +
                    '}';
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Element> priorityQueue = new PriorityQueue<>((e1, e2) -> Float.compare(e1.val, e2.val));
        priorityQueue.add(new Element(0, 0, 0.0f));
        List<Float> ans = new ArrayList<>();
        int k = 5;
        int q = 2;
        float sq=(float)Math.sqrt(q);
        while (k > 0) {
            System.out.println(priorityQueue);
            Element r = priorityQueue.remove();
            ans.add(r.val);
            int a = r.a;
            int b = r.b;
            Float value = r.val;
            priorityQueue.add(new Element(a + 1, b, value + 1));
            priorityQueue.add(new Element(a, b + 1, (float) (value + sq)));
            k--;
        }
        System.out.println(ans);
    }

}
