public class Queue<T> {
	//Head and tail of the queue
	private Node head;
	private Node tail;

	private class Node {
		T data;
		Node next;

		public Node (T item) {
			data = item;
		}
	}

	public Queue() {
		head = null;
		tail = null;
	}

	//Add item to queue
	public void add (T item) {
		Node n = new Node(item);
		if(head == null || tail == null) {
			head = tail = n;
		} else {
			tail.next = n;
			tail = n;
		}
	}

	//Remove items from queue
	public T remove() {
		if(head == null || tail == null) {
			return null;
		}
		else if (head == tail) {
			T item = head.data;
			head = tail = null;
			return item;
		}
		else {
			T item = head.data;
			head = head.next;
			return item;
		}
	}

	//Peek head of queue
	public T element() {
		if(head == null) {
			return null;
		} else {
			return head.data;
		}
	}

	//Check if head is empty
	public boolean empty() {
		return head == null;
	}
}

