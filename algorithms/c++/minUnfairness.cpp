#include <iostream>
#include <algorithm>
#include <climits>
using namespace std;


// It is NOT mandatory to use the provided template. You can handle the IO section differently.

int main() {
	/* The code required to enter n,k, candies is provided*/

	int N, K, unfairness;
	cin >> N >> K;
	int candies[N];
	for (int i=0; i<N; i++)
		cin >> candies[i];

	/** Write the solution code here. Compute the result, store in  the variable unfairness --
	  and output it**/
	unfairness = INT_MAX;
	// Sorting the integers
	sort(candies, candies + N);
	// Sliding a K-integer window on the sorted array to calculate max - min
	for(int i=0; i<=(N-K); i++) {
		if((candies[i+K-1] - candies[i]) < unfairness) {
			unfairness = candies[i+K-1] - candies[i];
		}
	}
	cout << unfairness << endl;
	return 0;
}

