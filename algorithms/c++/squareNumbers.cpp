#include <cmath>
#include <iostream>
using namespace std;


int main() {
	/* Enter your code here. Read input from STDIN. Print output to STDOUT */
	int cases;
	int a,b,sqInts = 0,temp1, temp2;
	cin >> cases;

	for(int i = 0; i < cases; i++) {
		cin >> a >> b;
		temp1 = (int) sqrt(a);
		temp2 = (int) sqrt(b);
		if((temp1*temp1) == a) {
			temp1--;
		}

		cout << temp2 - temp1 << endl;
	}
	return 0;
}

