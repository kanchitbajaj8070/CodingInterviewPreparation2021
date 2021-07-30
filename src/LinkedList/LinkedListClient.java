package LinkedList;

import java.util.LinkedList;

public class LinkedListClient {
    public static void main(String[] args) {
//        BasicLinkedListOperations list = new BasicLinkedListOperations();
//
//        list.insert(2);
//        list.insert(11);
//        list.insert(12);
//        list.print();
//
//        list.deleteNodeByValue(2);
//        list.print();
//        list.insertAtHead(1);
//        list.print();
//        list.insertInMiddle(55);
//        list.print();
//        list.insertAtIndex(14, 4);
//        list.print();
//        System.out.println(list.search(55).val);
//        list.iterativeReverse();
//        list.print();
//        list.iterativeReverse();
//        list.print();
//        System.out.println(list.kthNodeFromEnd(1).val);
//        BasicLinkedListOperations m1 = new BasicLinkedListOperations();
//        BasicLinkedListOperations m2 = new BasicLinkedListOperations();
//        m1.insert(2);
//        m1.insert(6);
//        m1.insert(8);
//        m1.insert(22);
//        m2.insert(3);
//        m2.insert(4);
//        m2.insert(9);
//        System.out.println("*****merge********");
//        m1.print();
//        m2.print();
//        BasicLinkedListOperations.mergeRecursiveWithoutNewHeadCreated(m1, m2);
////        BasicLinkedListOperations.mergeTwoSortedLinkedList(m1,m2);
////        BasicLinkedListOperations.mergeTwoSortedLinkedListsRecursively(m1,m2);
//
//        BasicLinkedListOperations list3 = new BasicLinkedListOperations();
//        for (int i = 0; i < 20; i++)
//            list3.insert(((int) (Math.random() * 500)));
//        System.out.println("###############Unsorted linked list ##############");
//list3.print();
//
//        System.out.println("###############SORTEDlinked list ##############");
//list3.sortLinkedList();
//
//BasicLinkedListOperations listWithCycle=new BasicLinkedListOperations();
//        System.out.println("testing floyd cycle detection NAD REMOVAL LOGIC");
//        for (int i = 0; i < 10; i++)
//            listWithCycle.insert(((int) (Math.random() * 500)));
//       //should throw exception  listWithCycle.print();
//        System.out.println(listWithCycle.kthNodeFromEnd(1).val);
//        System.out.println(listWithCycle.kthNodeFromEnd(8).val);
//        listWithCycle.kthNodeFromEnd(1).next=listWithCycle.kthNodeFromEnd(8);
// System.out.println();
//        System.out.println(listWithCycle.hasCycle());
//        System.out.println(list3.hasCycle());
//        listWithCycle.removeCycle();
//        System.out.println(listWithCycle.hasCycle());
//        listWithCycle.print();

        BasicLinkedListOperations listForKreverseTest = new BasicLinkedListOperations();
        for (int i = 0; i < 11; i++)
            listForKreverseTest.insert(((int) (Math.random() * 500)));
        listForKreverseTest.print();
        listForKreverseTest.kreverse(listForKreverseTest.getHead(),3);
        listForKreverseTest.print();
    }
}
