package com.akp.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheUsingDoublyLinkedListAndHashMap {
	private DoublyLinkedList list;
	private Map<Integer, DoublyLinkedList.Node> map;
	private final int cacheSize;

	public LRUCacheUsingDoublyLinkedListAndHashMap(int cacheSize) {
		this.cacheSize = cacheSize;
		list = new DoublyLinkedList(4);
		map = new HashMap<Integer, DoublyLinkedList.Node>();
	}

	public void accessData(int data) {
		DoublyLinkedList.Node node = null;
		if (map.containsKey(data)) {
			node = map.get(data);
			list.moveDataToHead(node);
		} else {
			// If size is full we'll remove the the tail from the list
			if (list.getCurrSize() == list.getSize()) {
				map.remove(list.getTail().getData());
			}
			node = list.add(data);
			map.put(data, node);
		}
	}

	public void printCacheState() {
		list.printList();
		System.out.println();
	}

	public static void main(String[] args) {
		int cacheSize = 4;
		LRUCacheUsingDoublyLinkedListAndHashMap cache = new LRUCacheUsingDoublyLinkedListAndHashMap(cacheSize);
		cache.accessData(4);
		cache.printCacheState();
		cache.accessData(2);
		cache.printCacheState();
		cache.accessData(1);
		cache.printCacheState();
		cache.accessData(1);
		cache.printCacheState();
		cache.accessData(4);
		cache.printCacheState();
		cache.accessData(3);
		cache.printCacheState();
		cache.accessData(7);
		cache.printCacheState();
		cache.accessData(8);
		cache.printCacheState();
		cache.accessData(3);
		cache.printCacheState();
	}
}

class DoublyLinkedList {

	private final int size;
	private int currSize;
	private Node head;
	private Node tail;

	public DoublyLinkedList(int size) {
		this.size = size;
		currSize = 0;
	}

	public Node getTail() {
		return tail;
	}

	public Node gethead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public void printList() {
		if (head == null) {
			return;
		}
		Node tmp = head;
		while (tmp != null) {
			System.out.print(tmp);
			tmp = tmp.getNext();
		}
	}

	public Node add(int data) {
		Node node = new Node(data);
		if (head == null) {
			head = node;
			tail = node;
			currSize = 1;
			return node;
		} else if (currSize < size) {
			currSize++;
		} else {
			tail = tail.getPrev();
			tail.setNext(null);
		}

		node.setNext(head);
		head.setPrev(node);

		return node;
	}

	public void moveDataToHead(Node node) {
		if (node == null || node == head) {
			return;
		}

		if (node == tail) {
			tail = tail.getPrev();
			tail.setNext(null);
		}

		Node prev = node.getPrev();
		Node next = node.getNext();
		prev.setNext(next);

		if (next != null) {
			next.setPrev(prev);
		}

		node.setPrev(null);
		node.setNext(head);
		head.setPrev(node);
		head = node;
	}

	public int getCurrSize() {
		return currSize;
	}

	public int getSize() {
		return size;
	}

	public void setCurrSize(int currSize) {
		this.currSize = currSize;
	}

	static class Node {
		private int data;
		private Node prev, next;

		Node(int data) {
			this.data = data;
			prev = next = null;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getPrev() {
			return prev;
		}

		public void setPrev(Node prev) {
			this.prev = prev;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}

}
