package Trees;

public class BSTMorrisTransversal extends BSTmoreQues {
    public static void main(String[] args) {
        BSTMorrisTransversal tree = new BSTMorrisTransversal();
        tree.populateTree();
        System.out.println("inorder before morris");
        tree.inorder();
        System.out.println("morris transversal ");
        tree.morrisInorderTransversa(tree.root);
        System.out.println();
        System.out.println("inorder after morris");
        tree.inorder();
        System.out.println();
        System.out.println("preorder before morris");
        tree.preorder();
        System.out.println();
        System.out.println("preorder with morris");
        tree.morrisPreorder(tree.root);
        System.out.println();
        System.out.println("preorer after morris");
        tree.preorder();
    }

    private void morrisInorderTransversa(Node root) {
        Node cur = root;
        while (cur != null) {
            //if lefis null ->print cur , move to right
            if (cur.left == null) {
                System.out.print(cur.value + " , ");
                cur = cur.right;
            } else {
                //if left is not null,find the last node of tree rooted a left and make a connection/thread to cur
                //this will help us to backetrack when we have printed finishing the left subtree
                //now if the rightmost is null, make a thread;
                //
                Node left = cur.left;
                Node rightMost = left;
                while (rightMost.right != null && rightMost.right != cur)
                    rightMost = rightMost.right;
                if (rightMost.right == null) {
                    rightMost.right = cur;
                    cur = cur.left;
                } else {
                    rightMost.right = null;
                    System.out.print(cur.value + " , ");
                    cur = cur.right;
                }

            }
        }
    }
    private void morrisPreorder(Node root) {
        Node cur = root;
        while (cur != null) {

            if (cur.left == null) {
                System.out.print(cur.value + " , ");
                cur = cur.right;
            } else {
                Node left = cur.left;
                Node rightMost = left;
                while (rightMost.right != null && rightMost.right != cur)
                    rightMost = rightMost.right;
                if (rightMost.right == null) {
                    rightMost.right = cur;
                    System.out.print(cur.value + " , "); //whenever we are root, we are marking thread of left subtree
                    cur = cur.left;
                } else {
                    rightMost.right = null;
                    cur = cur.right;
                }

            }
        }
    }
}
