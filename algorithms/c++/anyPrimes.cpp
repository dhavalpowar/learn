#include <iostream>
using namespace std;


int isPrime(int &n) {
	int divider = 2;

	while(divider < n) {
		if(n % divider == 0) {
			return false;
		}
	}
	return true;
}

bool areAnyPrimes(int * arr, int &n) {
	for(int i = 0; i < n; i++) {
		if(isPrime(arr[i])) {
			return true;
		}
	}
	return false;
}

int main() {
	/* Enter your code here. Read input from STDIN. Print output to STDOUT */
	int cases, n;
	int * arr;
	cin >> cases;

	for(int i = 0; i < cases; i++) {
		cin >> n;
		arr = new int[n];
		for(int j = 0; j < n; j++) {
			cin >> arr[j];
		}
		cout << (areAnyPrimes(arr, n) ? "YES" : "NO") << endl;

		delete[] arr;
	}
	return 0;
}

