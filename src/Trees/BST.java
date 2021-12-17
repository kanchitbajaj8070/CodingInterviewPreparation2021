package Trees;

import java.util.*;

public class BST {
    public class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int v) {
            value = v;
        }

        Node(int a, Node left, Node right) {
            value = a;
            this.left = left;
            this.right = right;
        }
    }

    public Node root;

    public void add(int val) {
        if (root == null)
            root = new Node(val);
        else
            add(root, val);
    }

    private void add(Node root, int val) {

        if (root.value < val) {
            if (root.right == null)
                root.right = new Node(val);
            else
                add(root.right, val);
        } else {
            if (root.left == null)
                root.left = new Node(val);
            else
                add(root.left, val);
        }
    }

    public void preorder() {
        preorder(root);
        System.out.println();
    }

    private void preorder(Node root) {

        if (root == null)
            return;
        System.out.print(root.value + "   ");
        preorder(root.left);
        preorder(root.right);
    }

    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(Node root) {

        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.value + "   ");
        inorder(root.right);
    }

    public void postorder() {
        postorder(root);
    }

    private void postorder(Node root) {

        if (root == null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.value + "   ");
    }

    public void constructFromSortedArray(int[] arr)
    {
        root=constructFromSortedArray(arr,0,arr.length,root);
    }

    private Node constructFromSortedArray(int[] arr, int s, int e,  Node root) {

        if(s>=e)
            return null;
        int mid=s+((e-s)/2);
        Node nn=new Node(arr[mid]);
        Node left=constructFromSortedArray(arr,s,mid,root);
        Node right=constructFromSortedArray(arr,mid+1,e,root);
        nn.left=left;
        nn.right=right;
        return nn;
    }
     int fillWithSumOfLeft( Node root) {

        if(root==null)
            return 0;
        int left=fillWithSumOfLeft(root.left);
        int right=fillWithSumOfLeft(root.right);
        root.value+=left;
        return root.value;
    }

    public void convertLeavesToDll()
    {
    Node head=new Node(0);
    //left acts as prev, right acts as next
    Node tail=new Node(0);

        convertLeavesToDll(root,head,tail);
head=head.right;
while (head!=tail)
{
    System.out.print(head.value+" -> ");
    head=head.right;
}
tail=tail.left;
        System.out.println();
        while (tail!=null)
        {
            System.out.print(tail.value+" <- ");
            tail=tail.left;
        }
        System.out.println();
    }

    private void convertLeavesToDll(Node root, Node head, Node tail) {

        if(root==null)
            return ;
        convertLeavesToDll(root.left,head,tail);
     convertLeavesToDll(root.right,head,tail);
     Node left=root.left;
     Node right=root.right;
        if(root!=null&&left==null&&right==null)
        {
            System.out.println("*"+root.value+"*");
         if(head.right==null)
         {
             head.right=root;
             tail.left=root;
         }
         else
         {
             Node temp=tail.left;
             tail.left.right=root;
             root.left=temp;
             root.right=tail;
             tail.left=root;
             tail=root;
         }
        }

    }

    public Map<Integer,Integer> topView()
    {
        Map<Integer,Integer> map=new TreeMap<>();
        topView(root,map,0);
        System.out.println(map);
        return map;
    }

    private void topView(Node root, Map<Integer, Integer> map, int i) {
    if(root==null)
        return;
            if(!map.containsKey(i))
                map.put(i,root.value);
            topView(root.left,map,i-1);
            topView(root.right,map,i+1);

    }

    public Map<Integer, List<Integer>> leaves()
    {
        Map<Integer,List<Integer>> map=new TreeMap<>();
        leaves(root,map,0);
        System.out.println(map);
        return map;
    }

    private void leaves(Node root, Map<Integer, List<Integer>> map, int i) {
        if(root==null)
            return;
        if(root.left==null&&root.right==null)
        {   List<Integer> list=map.getOrDefault(i,new ArrayList<>());
                    list.add(root.value);
                    map.put(i,list);
        }
        leaves(root.left,map,i-1);
        leaves(root.right,map,i+1);
    }
}