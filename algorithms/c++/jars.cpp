#include <iostream>
using namespace std;


int main() {
    /* N => jars and M => operations */
    long N, M, jarFirst, jarLast, candies, totalCandies = 0;
    cin >> N >> M;
    for(long i = 0; i < M; i++) {
        cin >> jarFirst >> jarLast >> candies;
        totalCandies += ((jarLast-jarFirst + 1) * candies);
    }
    
    cout << (totalCandies / N) << endl;
    return 0;
}
