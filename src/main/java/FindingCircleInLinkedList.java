public class FindingCircleInLinkedList {
	static Node head;

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

	public int detectLoop() {
		Node slow = head, fast = head;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				System.out.println("Found Loop");
				return 1;
			}
		}
		System.out.println("Found no loop");
		return 0;
	}

	public static void main(String args[]) {
		FindingCircleInLinkedList llist = new FindingCircleInLinkedList();

		llist.push(20);
		llist.push(4);
		llist.push(15);
		llist.push(10);
		llist.push(11);

		llist.head.next.next.next = llist.head;

		llist.detectLoop();
	}
}
