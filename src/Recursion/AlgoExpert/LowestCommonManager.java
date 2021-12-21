package Recursion.AlgoExpert;

import java.util.*;

public class LowestCommonManager {
    private static final class Node {
        char val;
        List<Node> childs;
        Node parent;

        Node(char c) {
            val = c;
            childs = new ArrayList<>();
        }

    }

    Node root;

    private void createTree() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter root of tree");
        char ch = scanner.next().charAt(0);
        root = new Node(ch);
        createTree(root, scanner);
    }

    private void createTree(Node root, Scanner scanner) {
        if (root == null)
            return;
        System.out.println("How many children of " + root.val + " you want");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter " + (i + 1) + " th child of " + root.val + " ");
            char ch = scanner.next().charAt(0);
            Node child = new Node(ch);
            root.childs.add(child);
            createTree(child, scanner);
            child.parent = root;

        }
    }

    private void levelOrderTransversal() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (queue.size() > 1) {
            Node node = queue.remove();
            if (node == null) {
                queue.add(null);
                System.out.println();
                continue;
            }
            System.out.print("[ " + node.val + " , " + (node.parent == null ? "" : node.parent.val) + " ]");
            if (node.childs.size() > 0) {
                for (Node n : node.childs) {
                    if (n != null)
                        queue.add(n);
                }
            }
        }
        System.out.println();
    }

    public boolean pathFromRoot(Node root, char key, List<Character> path) {
        if (root.val == key) {
            path.add(key);
            System.out.println(path);
            return true;
        }
        path.add(root.val);
        for (int i = 0; i < root.childs.size(); i++) {
            if (pathFromRoot(root.childs.get(i), key, path)) {
                return true;
            }
        }
        path.remove(path.size() - 1);
        return false;
    }

    Character answer = null;

    public int findLowestCommonManager(Node root, char a, char b) {
        if (root == null) return 0;
        int bigans = (root.val == a) || (root.val == b) ? 1 : 0;
        for (int i = 0; i < root.childs.size(); i++) {
            int ans = findLowestCommonManager(root.childs.get(i), a, b);
            bigans += ans;
        }
        if (bigans == 2) {
            if (answer == null)
                answer = root.val;
        }
        return bigans;
    }

    public static void main(String[] args) {
        LowestCommonManager lowestCommonManager = new LowestCommonManager();
        lowestCommonManager.createTree();
        //lowestCommonManager.levelOrderTransversal();
//            List<Character> pathOne = new ArrayList<>();
//            List<Character> pathTwo = new ArrayList<>();
//            lowestCommonManager.pathFromRoot(lowestCommonManager.root, 'z', pathOne);
//            lowestCommonManager.pathFromRoot(lowestCommonManager.root, 'a', pathTwo);
//            if (pathOne.size() == 1 || pathTwo.size() == 1) {
//                System.out.println("LOWEST COMMON MANAGER IS => " + lowestCommonManager.root.val);
//                return;
//            }
//            for (int i = 0; i < Math.min(pathOne.size(), pathTwo.size()); i++) {
//                if (pathOne.get(i) != pathTwo.get(i)) {
//                    System.out.println("LOWEST COMMON MANAGER IS => " + pathOne.get(i - 1));
//                    break;
//                }
//            }
        System.out.println("+++++++++++");
        lowestCommonManager.findLowestCommonManager(lowestCommonManager.root, 'a', 'g');
        if(lowestCommonManager.answer==null)
            System.out.println("a");
        else
        System.out.println(lowestCommonManager.answer);
//        System.out.println("*******"+path);
    }

}
//a 5 b 3 g 0 h 4 o 0 p 2 t 0 u 0 q 0 r 1 v 3 w 0 x 1 z 0 y 0 i 0 c 1 j 0 d 2 k 0 l 0 e 0 f 2 m 0 n 0