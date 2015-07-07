#include<iostream>

using namespace std;

template<class T>
class LinkedList {

private:
	struct Node {
		Node * next;
		T data;
		Node(T d) {
			data = d;
			next = NULL;
		}

		Node() {
			data = NULL;
			next = NULL;
		}
	};

	Node * head;

public:
	LinkedList() {
		head = NULL;
	}

	~LinkedList() {
		if(head == NULL)
			return;
		Node * next = head;
		Node * curr;
		while(next != NULL) {
			curr = next->next;
			delete next;
			next = curr;
		}
	}
	void add(T data);
	bool remove(T data);
	bool removeAt(int index, Node* head);
	void display();


};

template<class T>
void LinkedList<T>::add(T data) {
	if(head == NULL) {
		head = new Node(data);
		return;
	}

	Node * curr = head;
	while(curr->next != NULL) {
		curr = curr->next;
	}

	curr->next = new Node(data);
}

template<class T>
void LinkedList<T>::display() {
	if(head == NULL) {
		return;
	}

	Node * curr = head;
	while(curr != NULL) {
		cout << curr->data << "\t";
		curr = curr->next;
	}
	cout << endl;
}

template<class T>
bool LinkedList<T>::remove(T data) {

	Node * curr = head;
	Node * prev = NULL;

	while(curr != NULL) {
		if(curr->data == data) {
			if(curr == head){
				head = head->next;
				delete curr;
				return true;
			}
			Node * toDelete = curr;
			prev->next = curr->next;
			delete toDelete;
			return true;
		}
		prev = curr;
		curr = curr->next;
	}
	return false;
}

int main() {
	LinkedList<double> * l = new LinkedList<double>();
	l->remove(10);
	l->display();
	delete l;
}