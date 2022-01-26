package Trees;

import java.util.ArrayList;
import java.util.List;

public class KLargestElementsWithPruningAndReverseInorder extends BSTmoreQues{
    public static void main(String[] args) {
        KLargestElementsWithPruningAndReverseInorder tree=new KLargestElementsWithPruningAndReverseInorder();
        tree.populateTree();
        tree.inorder();
        tree.getKLargestElements(4);
    }

    /* Find k largest element in BST */;
    public void getKLargestElements(int k)
    {
        List<Integer> ans=new ArrayList<>();
        getKLargestElements(k,root,ans);
        System.out.println(ans);

    }

    private void getKLargestElements(int k, Node root, List<Integer> ans) {
    if(root==null)
        return;
    getKLargestElements(k,root.right,ans);
            if(ans.size()<k)
            {
                ans.add(root.value);
            }
            else
                return;
        getKLargestElements(k,root.left,ans);
    }

}
