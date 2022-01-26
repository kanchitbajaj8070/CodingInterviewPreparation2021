package Heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortANearlySortedArray {
    public static void main(String[] args) {
        int [] a={ 5,1, 3, 2, 8, 9,11};
        int k=3;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<=k;i++)
            pq.add(a[i]);
        int indexOfArray=0;
        int ptr=k+1;
        System.out.println(Arrays.toString(a));
        while(!pq.isEmpty())
        {
            a[indexOfArray]=pq.remove();
            if(ptr<a.length)
            {   pq.add(a[ptr]);
                ptr++;
            }
            indexOfArray++;
        }
        System.out.println(Arrays.toString(a));
    }
}
