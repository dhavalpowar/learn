#include <iostream>
#include <string>
using namespace std;

int minimumOps(string str) {
	int frontPtr = 0;
	int backPtr  = str.length() - 1;
	int operations = 0;

	while(frontPtr <= backPtr) {
		if(str[frontPtr] > str[backPtr]) {
			operations += str[frontPtr] - str[backPtr];
		} else if(str[frontPtr] < str[backPtr]) {
			operations += str[backPtr] - str[frontPtr];
		}
		frontPtr++;
		backPtr--;
	}
	return operations;
}

int main() {
	int cases;
	string str;
	cin >> cases;
	for (int i = 0; i < cases; i++) {
		cin >> str;
		cout << minimumOps(str) << endl;
	}
	return 0;
}

