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

	//Remove at index
	public boolean removeAt(int index) {
		//If head is null
		if(head == null)
			return false;
		//If index is 0 --> Removing head
		if(index == 0) {
			head = head.next;
			return true;
		}
		//If index > 0
		//Pointer to head
		Node ptr = head;
		//Decrement index so that it points to an element previous to one being deleted 
		index = index - 1;
		//Run until index is 0
		while(index > 0) {
			//If the current ptr and its next pointer are not null
			if(ptr != null && ptr.next != null) {
				//Point to next element
				ptr = ptr.next;
				//Decrement index
				index--;
			//If either current or next pointer is null,
			//it means that index specified is out of bound
			} else {
				return false;
			}
		}
		//If the next pointer is not null, then assign curr pointers next to curr pointer's next next
		if(ptr.next != null && index >= 0) {
			ptr.next = ptr.next.next;
			return true;
		}
		return false;
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
