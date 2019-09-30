
class LinkedList {
	Node head; // head of list

	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void push(int new_data) {
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}

	void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	void deleteAlternate() {
		Node current = head;
		while(current != null && current.next != null) {
			current.next = current.next.next;
			current = current.next;
		}
	}
}

public class DeletingAlternateNodeFromLinkedList {
	public static void main(String args[]) {
		LinkedList list = new LinkedList();

		list.push(5);
		list.push(4);
		list.push(3);
		list.push(2);
		list.push(1);

		System.out.println("Linked List before calling deleteAlt() ");
		list.printList();
		
		list.deleteAlternate();
		
		System.out.println("Linked List after calling deleteAlt() ");
		list.printList();
	}
}
