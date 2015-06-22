#include<iostream>
#include<algorithm>
using namespace std;

void abc (int &n) {
	//cout << n << endl;
	n = 20;
}

int main (){
	string x = "Hello";
	cout << (x[2] > x[4]) << endl;

	return 0;
}
