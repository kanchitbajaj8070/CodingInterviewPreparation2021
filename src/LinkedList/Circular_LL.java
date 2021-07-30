package LinkedList;

public class Circular_LL {
    public static class Node {
        int val;
        Node next;

        Node(int val, Node ptr) {
            this.val = val;
            this.next = ptr;
        }
    }

    private Node head;

    public static void main(String[] args) {
        Circular_LL list = new Circular_LL();
        list.insertAtHead(2);
        list.insertAtHead(5);
        list.insertAtHead(12);
        list.insertAtHead(55);
        list.print();
        list.delete(12);
        list.print();
        list.delete(55);
        list.print();
    }

    public void insertAtHead(int data) {
        Node nn = new Node(data, head);
        Node tail = head;
        if (head != null) { //atleast one node in list
            while (tail.next != head)
                tail = tail.next;
            tail.next = nn;
        } else {//when no node present , then we need a self loop on the new element
            //so no problem occur when more elements are inserted
            //1st inserted element must have self -loop
            nn.next = nn;
        }
        head = nn;
    }

    public void print() {
        Node temp = head;
        while (temp != null && temp.next != head) {
            System.out.print(temp.val + " ,   ");
            temp = temp.next;
        }
        System.out.println(temp.val + " ,  " + head.val);
    }

    public Node getNode(int data) {
        Node trav = head;
        if (trav == null)
            return null;
        while (trav.next != head) {
            if (trav.val == data)
                return trav;
            trav = trav.next;
        }
        //check for tail node
        if (trav.val == data)
            return trav;

        return null;
    }

    public void delete(int data) {
        Node toDelete = getNode(data);
        if (toDelete == null)
            return;
        if (toDelete == head && head.next == head) {
            //one node case;
            head = null;
            return;
        }
        if (toDelete != head) {
            Node trav = head;
            Node prev = null;
            while (trav != toDelete) {
                prev = trav;
                trav = trav.next;
            }
            prev.next = trav.next;// fails in case of head, we need to move
            //head pointer to the next node
        } else {
            head=head.next;//(very important step, the only diff )
            Node trav = head;//start from one forward , because we have atleast tewo nodes in list
            Node prev = null;
            while (trav != toDelete) {
                prev = trav;
                trav = trav.next;
            }
            prev.next = trav.next;
        }
    }
}