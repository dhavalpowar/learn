#include <iostream>
using namespace std;


int main() {
	/* Enter your code here. Read input from STDIN. Print output to STDOUT */
	int cases;
	long n, a, b, smallest, largest, difference, temp;
	cin >> cases;

	for(int i = 0; i < cases; i++) {
		cin >> n >> a >> b;
		smallest = (n-1) * a;
		largest  = (n-1) * b;
		difference = b - a;
		temp = smallest;
		cout << smallest << " ";
		while(temp < largest) {
			cout << (temp + difference) << " ";
			temp += difference;
		}
		cout  << endl;
	}
	return 0;
}

