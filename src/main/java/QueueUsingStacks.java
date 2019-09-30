import java.util.Stack;

public class QueueUsingStacks {
	public static void main(String[] args) {
		MyQueue<Integer> myQueue = new MyQueue<Integer>();

		myQueue.enqueue(1);
		myQueue.enqueue(2);

		System.out.println(myQueue.peek());

		System.out.println(myQueue.dequeue());
		
		myQueue.enqueue(3);
		myQueue.enqueue(4);
		myQueue.enqueue(5);
		
		System.out.println(myQueue.peek());

		System.out.println(myQueue.dequeue());
		
		System.out.println(myQueue.peek());

		System.out.println(myQueue.dequeue());
	}
}

class MyQueue<Integer> {
	private Stack<Integer> newOnTopStack = new Stack<Integer>();
	private Stack<Integer> oldOnTopStack = new Stack<Integer>();

	// Adding element on queue
	public void enqueue(Integer element) {
		// Insertion will always happen in newOnTopStack
		newOnTopStack.push(element);
	}

	// Deleting element from queue
	public Integer dequeue() {
		// it will always be performed from oldOnTopStack
		// If oldOnTopStack is empty them we have to copy elements from newOnTopStack
		if (oldOnTopStack.isEmpty()) {
			swapStacks();
		}
		return oldOnTopStack.pop();
	}

	// peeking the front of the queue
	public Integer peek() {
		// it will always be performed from oldOnTopStack
		// If oldOnTopStack is empty them we have to copy elements from newOnTopStack
		System.out.println("is old on top stack empty while peeking : " + oldOnTopStack.isEmpty());
		if (oldOnTopStack.isEmpty()) {
			swapStacks();
		}
		System.out.println("Stacks after swapping : ");
		System.out.println("oldOnTopStack : " + oldOnTopStack);
		System.out.println("newOnTopStack : " + newOnTopStack);
		return oldOnTopStack.peek();
	}

	private void swapStacks() {
		while (!newOnTopStack.isEmpty()) {
			oldOnTopStack.push(newOnTopStack.pop());
		}
	}
}