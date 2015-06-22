public class LinkedList<T> {
	
	//The head of the linked list
	private Node head;

	//Node class private to LinkedList
	private class Node {
		T data;
		Node next;

		public Node(T t) {
			data = t;
		}
	}

	public LinkedList() {
		head = null;
	}

	//Add an item
	public void add (T item) {
		//If head is null
		if(head == null) {
			head = new Node(item);
		}
		//If head is not null
		else {
			Node current = head;
			while(current.next != null) {
				current = current.next;
			}
			current.next = new Node(item);
		}
	}

	//Remove an item
	public boolean remove (T item) {
		//If head is null
		if(head == null) {
			return false;
		}
		//If head is not null
		else {
			Node previous = null;
			Node current = head;

			while(current != null) {
				if(item == current.data) {
					if(head == current) {
						head = head.next;
					} else {
						previous.next = current.next;
					}
					current = null;
					return true;
				} else {
					previous = current;
					current = current.next;
				}
			}
			return false;
		}
	}

	public void print() {
		if(head == null) {
			return;
		} else if (head.next == null) {
			System.out.println(head.data);
		} else {
			Node n = head;
			while(n != null) {
				System.out.println(n.data);
				n = n.next;
			}
		}
	}
}
