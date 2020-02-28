package com.akp.gfg.practice.linkedlist;

public class LengthOfLinkedList {
    private Node head;

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = next;
        }
    }

    public int getSizeIteratively(Node node) {
        int length = 0;
        while (node.next != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    public int getSizeRecursively(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + getSizeIteratively(node.next);
    }

    public static void main(String[] args) {
        LengthOfLinkedList list = new LengthOfLinkedList();
        list.head = new Node(50);
        list.head.next = new Node(20);
        list.head.next.next = new Node(15);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(10);
        list.head.next.next.next.next.next = new Node(11);

        System.out.println("size : " + list.getSizeRecursively(list.head));
        System.out.println("size iteratively : "+list.getSizeIteratively(list.head));
    }


}
