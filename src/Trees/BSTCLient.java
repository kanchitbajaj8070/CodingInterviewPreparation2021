package Trees;

public class BSTCLient {
    public static void main(String[] args) {
        BST tree=new BST();
        tree.add(14);
        tree.add(12);
        tree.add(13);
        tree.add(7);
        tree.add(21);
        tree.add(19);
        tree.add(17);
        tree.add(23);

        tree.add(27);
        //tree.add(18);
        tree.add(22);
        tree.inorder();
        //tree.fillWithSumOfLeft(tree.root);
        tree.inorder();
        tree.convertLeavesToDll();
//        tree.postorder();
//        System.out.println();
//        tree.preorder();
//int[] arr={1,2,3,4,5,6};
//tree.constructFromSortedArray(arr);
//tree.inorder();



    }
}
