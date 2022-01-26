package Heaps;

import java.util.PriorityQueue;

public class ClosestRangeInThreeSortedArray {
    public static final class Answer {
        int range;
        int min;
        int max;

        @Override
        public String toString() {
            return new StringBuilder().append("RANGE = ").append(range).append(" , MIN = ").append(min).append(" , MAX= ").append(max).toString();
        }
    }

    public static class Element {
        int arrayIndex;
        int elementIndex;
        int element;

        public Element(int arrayIndex, int elementIndex, int element) {
            this.arrayIndex = arrayIndex;
            this.elementIndex = elementIndex;
            this.element = element;
        }
    }

    public static void main(String[] args) {
        //find the closest range containing all element of a,b,c
        int[] a = {5, 10, 15};
        int[] b = {3, 6, 9, 12, 15};
        int[] c = {8, 16, 24};
        //answer is 1, (15,15,16) range =15-16
        Answer answer = new Answer();
        PriorityQueue<Element> pq = new PriorityQueue<>((e1, e2) -> {
            return e1.element - e2.element;
        });
        int max = Math.max(a[0], Math.max(b[0], c[0]));
        int min = Math.min(a[0], Math.min(b[0], c[0]));
        pq.add(new Element(0, 0, a[0]));
        pq.add(new Element(1, 0, b[0]));
        pq.add(new Element(2, 0, c[0]));
        answer.range = max - min;
        answer.min = min;
        answer.max = max;
        while (pq.size() == 3) {
            Element e = pq.remove();
            Element element = getElementTOInsert(a, b, c, e);
            if (element == null)
                break;
            if (element.element > max)
                max = element.element;
            pq.add(element);
            min = pq.peek().element;
            if (answer.range > (max - min)) {
                answer.range = max - min;
                answer.max = max;
                answer.min = min;
            }
        }
        System.out.println(answer);
    }

    private static Element getElementTOInsert(int[] a, int[] b, int[] c, Element e) {
        if (e.arrayIndex == 0) {
            if (e.elementIndex + 1 < a.length) {
                e.elementIndex++;
                e.element = a[e.elementIndex];
                return e;
            }
        }
        if (e.arrayIndex == 1) {
            if (e.elementIndex + 1 < b.length) {
                e.elementIndex++;
                e.element = b[e.elementIndex];
                return e;
            }
        }
        if (e.arrayIndex == 2) {
            if (e.elementIndex + 1 < c.length) {
                e.elementIndex++;
                e.element = c[e.elementIndex];
                return e;
            }
        }
        return null;

    }

}
