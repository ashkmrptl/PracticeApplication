package com.akp.gfg.practice.linkedlist;

public class FindingMiddleElemInLinkedList {
	Node head;

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	public void findMiddleElement(Node node) {
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		System.out.println("Middle elem is : " + slow.data);
	}

	public static void main(String[] args) {
		FindingMiddleElemInLinkedList list = new FindingMiddleElemInLinkedList();
		list.head = new Node(50);
		list.head.next = new Node(20);
		list.head.next.next = new Node(15);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(10);
		list.head.next.next.next.next.next = new Node(11);

		list.findMiddleElement(list.head);

	}
}
