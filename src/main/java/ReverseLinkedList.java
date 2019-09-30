public class ReverseLinkedList {
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.head = new MyLinkedList.Node(1);
		list.head.next = new MyLinkedList.Node(2);
		list.head.next.next = new MyLinkedList.Node(3);
		list.head.next.next.next = new MyLinkedList.Node(4);

		System.out.println("Given Linked list");
		list.printList(list.head);
		list.head = list.reverse(list.head);
		System.out.println("");
		System.out.println("Reversed linked list ");
		list.printList(list.head);
	}
}

class MyLinkedList {
	static Node head;

	static class Node {

		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	// prints content of double linked list
	void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public Node reverse(Node node) {
		Node prev = null;
		Node current = head;
		Node next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		node = prev;

		return node;
	}
}
