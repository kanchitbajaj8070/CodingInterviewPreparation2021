package Trees;

import java.util.Scanner;

public class BSTwithParentPointer {
    public class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        Node(int v) {
            value = v;
        }

        Node(int a, Node left, Node right) {
            value = a;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "[ "+value + "  , "+ ((parent!=null)?parent.value:null)+" ]";
        }
    }

    public Node root;
    public static void main(String[] args) {
        BSTwithParentPointer tree=new BSTwithParentPointer();
        tree.populateTree();
        tree.inorder();
        tree.inorderWithNoExtraSpace();
    }
    /*    50
      /      \
   30         60 //->4 answer
  /   \      /    \
 5    20   45      70
          /        / \
         10       85 90
   */
    public void populateTree() {
        //Scanner sc = new Scanner("1 true 2 true 4 true 8 false false true 9 false false true 5 true 10 false false false true 3 true 6 false false true 7 false false");
        Scanner sc = new Scanner("50 true 30 true 5 false false true 20 false false true 60 true 45 true 10 false false false  true 70 true 85 false false true 90 false false");
        System.out.println("Enter root of tree");
        int n = sc.nextInt();
        this.root = new Node(n);
        populateTree(this.root, sc);
    }
    private void populateTree(Node root, Scanner sc) {

        System.out.println("Any Left Child Of " + root.value);
        boolean leftChild = sc.nextBoolean();
        if (leftChild) {
            System.out.println("Enter left child of " + root.value);
            int left = sc.nextInt();
            Node nn = new Node(left);
            root.left = nn;
            populateTree(nn, sc);
            nn.parent=root;
        }

        System.out.println("Any Right Child Of " + root.value);
        boolean rightChild = sc.nextBoolean();
        if (rightChild) {
            System.out.println("Enter right Child of " + root.value);
            int right = sc.nextInt();
            Node nn = new Node(right);
            root.right = nn;
            populateTree(nn, sc);
            nn.parent=root;
        }
    }
    public void inorder() {
        inorder(this.root);
        System.out.println();
    }

    private void inorder(Node root) {

        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.toString());
        inorder(root.right);
    }
    private void inorderWithNoExtraSpace()
    {
        Node prev=null;
        Node cur=root;
        Node next=null;
        while(cur!=null) {

            if (cur.parent == prev) {
                if (cur.left != null)
                    next = cur.left;
                else {
                    System.out.print(cur.value + " , ");
                    next = cur.right == null ? cur.parent : cur.right;
                }
            } else if (cur.left == prev) {
                System.out.print(cur.value + " , ");
                next = cur.right == null ? cur.parent : cur.right;
            }
            else
                next=cur.parent;
                prev=cur;
                cur=next;
            }
        }
}
