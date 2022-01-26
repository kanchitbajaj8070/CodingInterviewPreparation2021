package Heaps;

public class HeapClient {
    public static void main(String[] args) {

        Heaps heap = new Heaps(new int[]{9, 4, 6, 3, 1, 7});
        heap.add(5);
        System.out.println(heap.heap);
//        for (int i = 1; i <= 6; i++)
//            heap.remove();
        heap.heapSort();

    }
}
