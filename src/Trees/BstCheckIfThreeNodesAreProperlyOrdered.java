package Trees;

public class BstCheckIfThreeNodesAreProperlyOrdered extends BSTmoreQues {

    public static final class OrderInfo {
        boolean didAncestorCome = false;
        boolean didMiddleCome = false;
        boolean didMiddleComeAfterAncestor = false;
    }

    /*    50
      /      \
   30         60
  /   \      /    \
 5    40   55      70
                 / \
                65 90
   */
        public static void main(String[] args) {
            BstCheckIfThreeNodesAreProperlyOrdered tree = new BstCheckIfThreeNodesAreProperlyOrdered();
            tree.populateTreeForBst();
            tree.inorder();
            Node trav=tree.root;
        int top=50;
        int middle=70;
        int bottom=10;
        OrderInfo answer=new OrderInfo();
        while(trav!=null)
        {
            if(trav.value==bottom)
                break;
           else if(trav.value==top)
                answer.didAncestorCome=true;
            else if (trav.value==middle)
            {
                answer.didMiddleCome=true;
                if(answer.didAncestorCome)
                    answer.didMiddleComeAfterAncestor=true;
            }else ;
            if(trav.value<bottom)
                trav=trav.right;
            else
                trav=trav.left;
        }
        if(answer.didAncestorCome&&answer.didMiddleComeAfterAncestor&&answer.didMiddleCome)
        {
            System.out.println("Nodes are correctly ordered");
        }
        else
            System.out.println("INCORRECT ORDER");
    }

    /*  eg top=50,middle=60,botoom=45 => true
        top=60 middle=90 bottom =85 ; false
     * Given three nodes in a bst
     * top -node should be proper ancestor of middle;
     * middle -node for comparison
     * bottom-proper descendant of middle*/


}
