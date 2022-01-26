package Trees;

public class ConstructBSTFromPreOrderOnly extends BST {
    /*
     *             45
     *         /         \
     *       35          55
     *      / \         /    \
     *   25      40   50      60
     *     \    /       \      /
     *     28  37       54   58
     * */
    public static void main(String[] args) {
        ConstructBSTFromPreOrderOnly tree = new ConstructBSTFromPreOrderOnly();
        int[] preorder = {45, 35, 25, 28, 40, 37, 55, 50, 54, 60, 58};
        Node newRoot = tree.makeTreeFromPreOrder(preorder, 0, preorder.length - 1);
        tree.root = newRoot;
        tree.inorder();
        System.out.println();
        tree.postorder();
        System.out.println();
        tree.preorder();
        System.out.println();
        tree.leaves();
    }

    private Node makeTreeFromPreOrder(int[] preorder, int s, int e) {
        if (s > e)
            return null;
        if (s == e)
            return new Node(preorder[s]);
        int rootElement = preorder[s];
        int partition = s;
        for (; partition <= e; partition++) {
            if (preorder[partition] > rootElement) {
                break;
            }
        }
        Node root = new Node(rootElement);
        root.left = makeTreeFromPreOrder(preorder, s + 1, partition - 1);
        root.right = makeTreeFromPreOrder(preorder, partition, e);
        return root;
    }

}
