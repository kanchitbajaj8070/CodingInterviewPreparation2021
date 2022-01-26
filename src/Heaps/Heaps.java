package Heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Heaps {
    public List<Integer> heap;

    Heaps(int[] a) {
        heap = new ArrayList<>();
        Arrays.stream(a).forEach(e -> heap.add(e));
        buildHeap();
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private int parent(int i) {
        return ((i + 1) / 2) - 1;
    }

    private void buildHeap() {
        int n = heap.size();
        for (int i = n / 2; i >= 0; i--)
            downHeapify(i, n);

    }

    private void swap(int i, int j) {
        Integer c = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, c);
    }

    private void downHeapify(int i, int size) {
        if (i >= size)
            return;
        int smallest = i;
        int left = left(i);
        int right = right(i);
        if (left < size && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }
        if (right < size && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }
        swap(i, smallest);
        if (smallest != i) {
            downHeapify(smallest, size);
        }
    }

    public void remove() {
        Integer pop = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        downHeapify(0, heap.size());
        System.out.println("Element removed is : " + pop);
    }

    private void upHeapify(int i, int size) {
        if (i >= size)
            return;
        int parent = parent(i);
        if (parent == -1)
            return;
        if (heap.get(parent) > heap.get(i)) {
            swap(parent, i);
            upHeapify(parent, size);
        } else
            return;
    }

    public void add(Integer e) {
        heap.add(e);
    }

    void heapSort() {
        int size = heap.size();
        for (int i = 0; i < size; i++) {
            swap(0, size - i - 1);
            downHeapify(0, size - i - 1);
        }
        System.out.println(heap);
        Collections.reverse(heap);
        System.out.println("correct: " + heap);
    }

}
