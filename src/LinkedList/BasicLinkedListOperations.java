package LinkedList;

import java.util.LinkedList;
import java.util.Objects;

public class BasicLinkedListOperations {
    public static class Node {
        int val;
        Node next;

        Node(int val, Node ptr) {
            this.val = val;
            this.next = ptr;
        }
    }

    private Node head;

    public void insert(int val) {
        if (Objects.isNull(head)) {
            head = new Node(val, null);

        } else {
            this.head = insert(head, val);
        }
    }

    private Node insert(Node head, int val) {

        if (head == null)
            return null;

        Node node = insert(head.next, val);
        if (node == null) {
            head.next = new Node(val, null);
        }
        return head;
    }

    public void print() {
        print(head);
        System.out.println();
    }

    private void print(Node head) {
        if (head == null)
            return;
        System.out.print(head.val + " -> ");
        print(head.next);
    }

    public void deleteNodeByValue(int val) {
        if (head != null && head.val == val) {
            head = head.next;
            return;
        } else {
            boolean ans = deleteNodeByValue(head, null, val);
            if (ans) {
                System.out.println("deleted");
            } else
                System.out.println("no such element exists in list");
        }

    }

    public void insertAtHead(int val) {
        if (Objects.isNull(head)) {
            head = new Node(val, null);
            return;
        } else {
            Node node = new Node(val, null);
            node.next = head;
            head = node;
        }
    }

    public void insertInMiddle(int val) {
        Node temp = new Node(val, null);
        if (head == null) {
            head = temp;
            return;
        }
        Node prev = null;
        Node slow = head;
        Node fast = head;
        while (slow != null && fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prev == null) {
            head.next = temp;
        } else {
            Node copy = prev.next;
            prev.next = temp;
            temp.next = copy;
        }

    }

    public int length() {
        int c = 0;
        Node trav = head;
        while (trav != null) {
            c++;
            trav = trav.next;
        }
        return c;
    }

    public void insertAtIndex(int val, int index) {
        if (index == 0)
            insertAtHead(val);
        else if (index == length())
            insert(val);
        else if (index > length()) {
            System.out.println("index out of range, cannot insert");
            throw new IndexOutOfBoundsException(index + " out of linked list index range");
        } else {
            int trav = 1;
            Node node = head;
            while (node != null && trav < index) {
                node = node.next;
                trav++;

            }
            Node temp = node.next;
            node.next = new Node(val, temp);

        }
    }

    private boolean deleteNodeByValue(Node head, Node prev, int val) {
        if (head == null)
            return false;
        if (head.val == val) {
            Node temp = head.next;
            prev.next = null;
            head.next = null;
            prev.next = temp;
            return true;
        }
        return deleteNodeByValue(head.next, head, val);


    }

    public Node search(int val) {
        Node trav = head;
        while (trav != null && trav.val != val)
            trav = trav.next;
        return trav;
    }

    public void reverse() {
        if (head == null) {
            throw new NullPointerException(" Linked list is empty");
        }
        reverse(head);

    }

    private Node reverse(Node head) {
        if (head.next == null) {
            this.setHead(head);
            return head;
        }
        Node next = reverse(head.next);
        next.next = head;
        head.next = null;
        return head;

    }

    public void iterativeReverse() {
        Node cur = head;
        Node prev = null;
        while (cur != null) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        this.head = prev;
    }

    public Node getHead() {
        return head;
    }

    public Node kthNodeFromEnd(int k) {
        if (k <= 0) {
            System.out.println("not possible");
            return null;
        }

        return kthNodeFromEnd(k, head);
    }

    private Node kthNodeFromEnd(int k, Node head) {
        int i = 1;
        if (k == length())
            return head;
        Node slow = head;
        Node fast = head;
        while (i <= k) {
            fast = fast.next;
            i++;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public static void mergeTwoSortedLinkedList(BasicLinkedListOperations l1,
                                                BasicLinkedListOperations l2) {
        BasicLinkedListOperations list = new BasicLinkedListOperations();
        list.insert(-1);
        Node cur1 = l1.head;
        Node cur2 = l2.head;
        Node finalhead = list.getHead();
        Node trav = finalhead;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                trav.next = cur1;
                cur1 = cur1.next;
            } else {
                trav.next = cur2;
                cur2 = cur2.next;
            }

            trav = trav.next;

        }
        while (cur1 != null) {
            trav.next = cur1;
            cur1 = cur1.next;
        }

        while (cur2 != null) {
            trav.next = cur2;
            cur2 = cur2.next;
        }

        list.setHead(finalhead.next);
        list.print();

    }

    public static void mergeTwoSortedLinkedListsRecursively(BasicLinkedListOperations list1, BasicLinkedListOperations l2) {
        Node head1 = list1.getHead();
        Node head2 = l2.getHead();
        Node newhead = null;
        if (head1.val < head2.val) {
            newhead = head1;
            head1 = head1.next;
        } else {
            newhead = head2;
            head2 = head2.next;
        }
        mergeRecursive(newhead, head1, head2);
        System.out.println("**********8Recursuve merge result********");
        while (newhead != null) {
            System.out.print(newhead.val + " , ");
            newhead = newhead.next;
        }
        System.out.println();

    }

    private static void mergeRecursive(BasicLinkedListOperations.Node trav, BasicLinkedListOperations.Node head1, BasicLinkedListOperations.Node head2) {
        if (head1 == null && head2 == null)
            return;
        if (head1 == null) {
            trav.next = head2;
            return;
        } else if (head2 == null) {
            trav.next = head1;
            return;
        } else if (head1.val < head2.val) {
            Node temp = head1.next;
            head1.next = null;
            trav.next = head1;
            head1 = temp;
        } else {
            Node temp = head2.next;
            head2.next = null;
            trav.next = head2;
            head2 = temp;
        }
        mergeRecursive(trav.next, head1, head2);
    }

    public static void mergeRecursiveWithoutNewHeadCreated(BasicLinkedListOperations l1, BasicLinkedListOperations l2) {
        System.out.println("**********Recursuve merge Without new head result********");
        Node newhead = mergeRecursiveWithoutNewHeadCreated(l1.getHead(), l2.getHead());
        while (newhead != null) {
            System.out.print(newhead.val + " , ");
            newhead = newhead.next;
        }
        System.out.println();
    }

    private static Node mergeRecursiveWithoutNewHeadCreated(BasicLinkedListOperations.Node head1, BasicLinkedListOperations.Node head2) {

        /*think if this function itervaatively. for you , you have to merge only two nodes . the rest
         * will be taken care by recursiion*/
        //base case
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;
        Node newheadOfSmallPartOfLinkedList = null;
        if (head1.val < head2.val) {
            newheadOfSmallPartOfLinkedList = head1;
            newheadOfSmallPartOfLinkedList.next = mergeRecursiveWithoutNewHeadCreated(head1.next, head2);
        } else {
            newheadOfSmallPartOfLinkedList = head2;
            newheadOfSmallPartOfLinkedList.next = mergeRecursiveWithoutNewHeadCreated(head1, head2.next);
        }
        return newheadOfSmallPartOfLinkedList;
    }

    public void sortLinkedList() {
        Node head = getHead();
        Node tail = head;
        while (tail.next != null)
            tail = tail.next;

        this.setHead(mergeSort(head, tail));
        this.print();
    }

    private Node mergeSort(BasicLinkedListOperations.Node head, BasicLinkedListOperations.Node tail) {
        if (head == tail)
            return head;
        if (head == null)
            return null;
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        Node temp = mid.next;
        mid.next=null;
        Node h1 = mergeSort(head, mid);
        Node h2 = mergeSort(temp, tail);
        Node h3=merge(h1,h2);
        return h3;


    }

    private BasicLinkedListOperations.Node merge(BasicLinkedListOperations.Node h1, BasicLinkedListOperations.Node h2) {
        return mergeRecursiveWithoutNewHeadCreated(h1,h2);
    }
public boolean hasCycle()
{
    Node slow=head;
    Node fast=head;
    while(fast!=null&&fast.next!=null)
    {
        slow=slow.next;
        fast=fast.next.next;
        if(slow==fast)
            return true;

    }
    return false;
}
public void removeCycle()
{
    if(!hasCycle())
        return;
    Node slow=head;
    Node fast=head;
    while(fast!=null&&fast.next!=null)
    {
        slow=slow.next;
        fast=fast.next.next;
        if(slow==fast)
            break;
    }
    //logic is that we need start of cycle. and the fact is
    //distance from head to start of cycle=distance from meeting point of pointer to start.
    //so we keep a pointer at start and one at meeting point and move them at same pace until they meet
    slow=head;
    Node prev=fast;
    while(slow!=fast)
    {prev=fast;
        slow=slow.next;
        fast=fast.next;
    }
    System.out.println("start of cycle is at "+ slow.val);
    System.out.println("need to remove link between "+prev.val+" and start of cycle");
prev.next=null;
}
public Node kreverse(Node start, int k)
{
    if(start==null)
        return null;
    Node prev=null;
    Node cur=start;
    Node next=null;
    Node ktail=start;
    for(int i=1;i<=k;i++)
    {
        if(cur==null)
            break;
        next=cur.next;
        cur.next=prev;
        prev=cur;
        cur=next;
    }
    if(ktail==this.head)
    {
        this.head=prev;
    }
    ktail.next=kreverse(cur,k);
    return prev;
}
}
