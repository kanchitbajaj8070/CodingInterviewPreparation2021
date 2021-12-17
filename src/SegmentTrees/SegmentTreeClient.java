package SegmentTrees;

import java.util.Arrays;

public class SegmentTreeClient {
    public static void main(String[] args) {
        int[] a=new int[]{3,-9,4,5};
        SegmentTree tree=new SegmentTree(a);
        System.out.println(tree.query(0,1));
        tree.update(0,4);//[4,-9,4,5]
        System.out.println(Arrays.toString(tree.result));
        tree.rangeIncrement(0,2,1);
      //  [5,-8,5,5]
        System.out.println(Arrays.toString(tree.result));
    }
}
