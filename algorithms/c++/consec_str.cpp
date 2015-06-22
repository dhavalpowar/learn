#include <iostream>
#include <string>
using namespace std;


int main() {
	int cases;
	cin >> cases;
	string str;
	int deletions;
	char firstOccurence;

	for (int i = 0; i < cases; i++) {
		cin >> str;
		deletions = 0;
		firstOccurence = str[0];
		for(string::iterator it = (str.begin() + 1); it != str.end(); ++it) {
			if(firstOccurence == *it) {
				deletions++;
			} else {
				firstOccurence = *it;
			}
		}
		cout << deletions << endl;
	}

	cout << ('D' - firstOccurence) << endl;
	return 0;
}

