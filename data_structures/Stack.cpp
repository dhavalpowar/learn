#include<iostream>

using namespace std;

template<class T>
class Stack {

	public:
		void push(T data);
		void pop();
		T top();

	private:

	struct Node {
		Node * next;
		T data;
	};

	Node * top;
};


