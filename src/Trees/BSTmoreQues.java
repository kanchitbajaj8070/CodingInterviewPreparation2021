package Trees;

import java.util.*;
import java.util.stream.Collectors;

public class BSTmoreQues extends BST {

    public static void main(String[] args) {
        BSTmoreQues tree = new BSTmoreQues();
        tree.populateTree();
        //tree.preorder();
        //tree.preOrderWithoutRecursion(tree.root);
        tree.inorder();
        //tree.kthNodeOfInorderTransversal(8, tree.root);
        //tree.treeInorderWithoutRecursion(tree.root);
        // System.out.println(tree.rootToPathSum(tree.root));
        //System.out.println(Arrays.toString(tree.sumOfAllPathsToLeaves(tree.root)));
        //System.out.println(tree.sumOfAllPathsToLeavesSimpleMethod(tree.root,0));
        //System.out.println(tree.doesRootToLeafPathSUmExists(tree.root,270));
        //tree.largestSubTreeComplete();
        tree.getSuccesor(45);
//        tree.populateTreeWithDescendants();
//        tree.inorderWithDescendants(tree.nodeWithDescendantsRoot);
//        System.out.println();
//        tree.kthNodeOfInorderTransversalWhenDescendantsInfoAvailable(2);

    }
    private static final class SuccesorAnswer
    {
        private Node ans;
    }
    public void getSuccesor(int n)
    {
        Node node=findNode(n,root);
        if(node==null)
            return;
        Integer ans=null;
        if(node.right!=null)
        {
            Node trav=node.right;
            while(trav.left!=null)
                trav=trav.left;
            System.out.println(trav.value);
        }
        else
        {
            SuccesorAnswer answer=new SuccesorAnswer();
            getSuccessor(answer,root,node,null);
            if(answer.ans==null)
                System.out.println("No succesor");
            else
                System.out.println(answer.ans.value);
        }

    }
    public void getSuccessor(SuccesorAnswer answer,Node root,Node key,Node lastLeft)
    {
        if(root==null)
            return;
        if(root==key)
        {   answer.ans=lastLeft;
            return;
        }
        getSuccessor(answer,root.left,key,root);
        getSuccessor(answer,root.right,key,lastLeft);
    }

    private Node findNode(int n,Node node) {
        if (node == null)
            return null;
        if (node.value == n)
            return node;
        Node l = findNode(n, node.left);
        if (l != null)
            return l;
        Node r = findNode(n, node.right);
        if (r != null)
            return r;
    return null;
    }

    private void kthNodeOfInorderTransversalWhenDescendantsInfoAvailable(int k)
    {
        Integer ans=kthNodeOfInorderTransversalWhenDescendantsInfoAvailable(nodeWithDescendantsRoot,k);
        if(ans==null)
            System.out.println(" not present");
        else
            System.out.println(ans);

    }
    private Integer  kthNodeOfInorderTransversalWhenDescendantsInfoAvailable(NodeWithDescendants root,int k)
    {
        if(root==null)
            return null;
        int leftSubTreeSize=(root.left==null)?0:root.left.descendants+1;
        if(leftSubTreeSize+1==k)
            return root.value;
        else if(k>leftSubTreeSize+1) return kthNodeOfInorderTransversalWhenDescendantsInfoAvailable(root.right,k-(leftSubTreeSize+1));
        else//whne leftsize +1 <k ;it lies in left tree
        return kthNodeOfInorderTransversalWhenDescendantsInfoAvailable(root.left,k);
    }

    public void kthNodeOfInorderTransversal(int k, Node root) {
        AnswerKthInorder ans = new AnswerKthInorder(k);
        kthNodeOfInorderTransversalHelper(root, ans);
        System.out.println(ans.ans);
    }

    public static final class AnswerKthInorder {
        int k;
        int ans;

        AnswerKthInorder(int k) {
            this.k = k;
        }
    }

    private void kthNodeOfInorderTransversalHelper(Node root, AnswerKthInorder ans) {
        if (root == null)
            return;
        kthNodeOfInorderTransversalHelper(root.left, ans);
        ans.k--;
        if(ans.k==0)
            ans.ans=root.value;
        kthNodeOfInorderTransversalHelper(root.right, ans);
    }

    public void preOrderWithoutRecursion(Node root) {
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        System.out.println();
        while (!(stack.isEmpty() && cur == null)) {
            while (cur != null) {
                stack.push(cur);
                System.out.print(cur.value + " , ");
                cur = cur.left;
            }

            cur = stack.pop().right;
        }
    }

    public void treeInorderWithoutRecursion(Node root) {
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        System.out.println();
        while (!(stack.isEmpty() && cur == null)) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.pop();
            System.out.print(top.value + " , ");
            cur = top.right;
        }

    }

    public boolean doesRootToLeafPathSUmExists(Node root, int sum) {
        if (root == null || sum <= 0)
            return false;
        if ((root.left == null && root.right == null))
            return (sum - root.value) == 0;
        boolean left = doesRootToLeafPathSUmExists(root.left, sum - root.value);
        boolean right = doesRootToLeafPathSUmExists(root.right, sum - root.value);
        return left || right;
    }

    public int sumOfAllPathsToLeavesSimpleMethod(Node root, int sumTillNow) {
        /*
         * Insighet here is to add contribution of the current node to all the paths as we move down to leaves and whern we reach a leaf
         * we return it
         * */
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return sumTillNow + root.value;

        int l = sumOfAllPathsToLeavesSimpleMethod(root.left, sumTillNow + root.value);
        int r = sumOfAllPathsToLeavesSimpleMethod(root.right, sumTillNow + root.value);
        return l + r;
    }

    public int[] sumOfAllPathsToLeaves(Node root) {
        if (root == null)
            return new int[]{0, 0};
        if (root.left == null && root.right == null)
            return new int[]{root.value, 1};
        int[] l = sumOfAllPathsToLeaves(root.left);
        int[] r = sumOfAllPathsToLeaves(root.right);
        int paths = l[1] + r[1];
        int sum = l[0] + r[0] + paths * root.value;
        return new int[]{sum, paths};
    }

    public List<Integer> rootToPathSum(Node root) {
        if (root == null)
            return new ArrayList<>();
        if (root.left == null && root.right == null) {
            List<Integer> l = new ArrayList<>();
            l.add(root.value);
            return l;
        }
        List<Integer> ans = new ArrayList<>();
        List<Integer> left = rootToPathSum(root.left);
        List<Integer> right = rootToPathSum(root.right);
        for (Integer e : left)
            ans.add(e + root.value);
        for (Integer e : right)
            ans.add(e + root.value);

        return ans;
    }

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
        }

        System.out.println("Any Right Child Of " + root.value);
        boolean rightChild = sc.nextBoolean();
        if (rightChild) {
            System.out.println("Enter right Child of " + root.value);
            int right = sc.nextInt();
            Node nn = new Node(right);
            root.right = nn;
            populateTree(nn, sc);
        }
    }

    public void populateTreeWithDescendants() {
      //  Scanner sc = new Scanner("1 true 2 true 4 true 8 false false true 9 false false true 5 true 10 false false false true 3 true 6 false false true 7 false false");
        Scanner sc = new Scanner("50 true 30 true 5 false false true 20 false false true 60 true 45 true 10 false false true 51 false false true 70 true 85 false false true 90 false false");
        System.out.println("Enter root of tree");
        int n = sc.nextInt();
        this.nodeWithDescendantsRoot = new NodeWithDescendants(n);
        populateTreeWithDescendants(this.nodeWithDescendantsRoot, sc);
    }
    private void populateTreeWithDescendants(NodeWithDescendants root, Scanner sc) {

        System.out.println("Any Left Child Of " + root.value);
        boolean leftChild = sc.nextBoolean();
        if (leftChild) {
            System.out.println("Enter left child of " + root.value);
            int left = sc.nextInt();
            NodeWithDescendants nn = new NodeWithDescendants(left);
            root.left = nn;
            root.descendants+=1;
            populateTreeWithDescendants(nn, sc);
            root.descendants+=nn.descendants;
        }

        System.out.println("Any Right Child Of " + root.value);
        boolean rightChild = sc.nextBoolean();
        if (rightChild) {
            System.out.println("Enter right Child of " + root.value);
            int right = sc.nextInt();
            NodeWithDescendants nn = new NodeWithDescendants(right);
            root.right = nn;
            root.descendants+=1;
            populateTreeWithDescendants(nn, sc);
            root.descendants+=nn.descendants;
        }
    }

    public static final class LargestSubTreeCompleteDTO {
        int numberOfNodes;
        int height;
        int maxSoFar;
        boolean isComplete;
        boolean isPerfect;

        public LargestSubTreeCompleteDTO(int numberOfNodes, int height, int maxSoFar, boolean isComplete, boolean isPerfect) {
            this.numberOfNodes = numberOfNodes;
            this.height = height;
            this.maxSoFar = maxSoFar;
            this.isComplete = isComplete;
            this.isPerfect = isPerfect;
        }

        @Override
        public String toString() {

            return ("{ Numebr of nodes= " + numberOfNodes + " , height = " + height + " , maximum value = " + maxSoFar + " }");
        }
    }

    public void largestSubTreeComplete() {
        LargestSubTreeCompleteDTO answer = largestSubTreeComplete(this.root);
        System.out.println(" Largest complete subtree is " + answer.maxSoFar);
    }

    public LargestSubTreeCompleteDTO largestSubTreeComplete(Node root) {

        if (root == null) {
            return new LargestSubTreeCompleteDTO(0, 0, 0, true, true);
        }
        LargestSubTreeCompleteDTO left = largestSubTreeComplete(root.left);
        LargestSubTreeCompleteDTO right = largestSubTreeComplete(root.right);
        int maxSOfAR = Math.max(left.maxSoFar, right.maxSoFar);
        int heightDiff = (left.height - right.height);
        int numberOfNodes = left.numberOfNodes + right.numberOfNodes + 1;
        if (heightDiff == 0) {
            boolean isPerfect = left.isPerfect && right.isPerfect;
            boolean isComplete = isPerfect || (left.isPerfect && right.isComplete);
            if (isComplete)
                return new LargestSubTreeCompleteDTO(numberOfNodes, Math.max(left.height, right.height) + 1, Math.max(numberOfNodes, maxSOfAR), isComplete, isPerfect);
            else
                return new LargestSubTreeCompleteDTO(numberOfNodes, Math.max(left.height, right.height) + 1, maxSOfAR, isComplete, isPerfect);
        } else if (heightDiff == 1) {
            if (left.isComplete && right.isPerfect)
                return new LargestSubTreeCompleteDTO(numberOfNodes, Math.max(left.height, right.height) + 1, Math.max(numberOfNodes, maxSOfAR), true, false);
            else
                return new LargestSubTreeCompleteDTO(numberOfNodes, Math.max(left.height, right.height) + 1, maxSOfAR, false, false);
        } else
            return new LargestSubTreeCompleteDTO(numberOfNodes, Math.max(left.height, right.height) + 1, maxSOfAR, false, false);

    }

    /*    50
      /      \
   30         60 //->4 answer
  /   \      /    \
 5    20   45      70
          /   \     / \
         10  51   85 90
   */
}

// 1 true 2 true 4 true 8 false false true 9 false false true 5 true 10 false false false true 3 true 6 false false true 7 false false
//50 true 30 true 5 false false true 20 false false true 60 true 45 true 10 false false false true 70 true 85 false false true 90 false false
