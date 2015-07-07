public class Stack<T> {
	//Top of the stack
	private Node top;

	private class Node {
		T data;
		Node next;

		public Node (T item) {
			data = item;
		}
	}

	public Stack() {
		top = null;
	}

	//Push item to stack
	public void push(T item) {
		Node n = new Node(item);
			n.next = top;
			top = n;
	}

	//Pop top of stack
	public T pop() {
		if(top == null) {
			return null;
		}
		else {
			top = top.next;
			return top == null ? null : top.data;
		}
	}

	//Peek top of stack
	public T peek() {
		if(top == null) {
			return null;
		} else {
			return top.data;
		}
	}

	//Check if stack is empty
	public boolean empty() {
		return top == null;
	}
}

