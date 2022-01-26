package Trees;

import java.util.ArrayList;
import java.util.List;

public class AllNodesInARange extends BSTmoreQues {
    /*    50
        /      \
     30         60
    /   \      /    \
   5    40   55      70
                   / \
                  65 90
     */
    public static void main(String[] args) {
        AllNodesInARange tree = new AllNodesInARange();
        tree.populateTreeForBst();
        tree.inorder();
        Node trav = tree.root;
        int[] range = {51, 75};
        List<Integer> ans = new ArrayList<>();
        fillAnswer(ans, trav, range);
        System.out.println(ans);
    }
    private static void fillAnswer(List<Integer> ans, Node node, int[] range) {
        if (node == null)
            return;
        if (node.value < range[0])
            fillAnswer(ans, node.right, range);
        else if (node.value > range[1])
            fillAnswer(ans, node.left, range);
        else {
            ans.add(node.value);
            fillAnswer(ans, node.left, range);
            fillAnswer(ans, node.right, range);
        }
    }
}

