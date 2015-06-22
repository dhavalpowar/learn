#include <iostream>
#include <string>
#include <map>
using namespace std;


int main() {

	string s;
	cin>>s;

	// Assign Flag a value of 0 (no palidrome) or 1 (palindrome)
	int flag = 1;

	// Map storing character and its count
	map<char,int> charMap;
	for(int i = 0; i < s.length(); i++) {
		if(charMap.count(s[i]) > 0) {
			charMap[s[i]]++;
		} else {
			charMap[s[i]] = 1;
		}
	}

	bool singleOddNumOfChar = false;
	for(map<char,int>::iterator it = charMap.begin(); it != charMap.end(); ++it) {
		// If the length of string is odd
		if(s.length() % 2 == 1) {
			// If character count is odd
			if(it->second % 2 == 1) {
				//If more than one character with odd number of characters
				if(singleOddNumOfChar == true) {
					flag = 0;
					break;
				} else {
					singleOddNumOfChar = true;
				}
			}
		}
		// If length of the string is even
		else {
			// If character count is odd
			if(it->second % 2 == 1) {
				flag = 0;
				break;
			}
		}
	}

	if(flag==0)
		cout<<"NO";
	else
		cout<<"YES";
	return 0;
}

