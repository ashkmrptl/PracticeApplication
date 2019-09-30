
public class RemovingCircleFromLinkedList {
	public static void main(String[] args) {

		CustomLinkedList list = new CustomLinkedList();

		list.head = new Node(50);
		list.head.next = new Node(20);
		list.head.next.next = new Node(15);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(10);

		System.out.println("is circle present before : " + list.isCirclePresent());

		// Adding circle
		list.head.next.next.next.next.next = list.head.next;

		System.out.println("is circle present after : " + list.isCirclePresent());
		list.printList(list.head);
	}
}

class Node {
	public Node(int data) {
		this.data = data;
		this.next = null;
	}

	Node next;
	int data;
}

class CustomLinkedList {
	Node head;

	public boolean isCirclePresent() {
		Node slow = head;
		Node fast = head;
		while (slow.next != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				removeLoop(slow, head);
				return true;
			}
		}
		return false;
	}

	private void removeLoop(Node loop, Node current) {
		Node ptr1 = null, ptr2 = null;
		ptr1 = current;
		while (true) {
			ptr2 = loop;
			while (ptr2.next != loop && ptr2.next != ptr1) {
				ptr2 = ptr2.next;
			}

			if (ptr2.next == ptr1) {
				break;
			}

			ptr1 = ptr1.next;
		}
		ptr2.next = null;
	}
	
	public void printList(Node head) {
		Node temp  = head;
		while(temp != null) {
			System.out.print(temp.data+"  ");
			temp = temp.next;
		}
	}
}
