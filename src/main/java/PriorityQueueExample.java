import java.util.PriorityQueue;

public class PriorityQueueExample {
	public static void main(String[] args) {
		PriorityQueue<String> queue = new PriorityQueue<>();
		queue.add("Ashish");
		queue.add("Kumar");
		queue.add("Patel");

		System.out.println("Queue front : " + queue.peek());

		System.out.println("Polling fist element : " + queue.poll());

		System.out.println("Queue front after poll : " + queue.peek());

		System.out.println("Removing element from queue : " + queue.remove("Patel"));

		System.out.println("Queue front after remove : " + queue.peek());
	}
}
