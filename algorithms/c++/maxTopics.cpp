#include <iostream>
#include <string>
using namespace std;

int maxTopicCount(string a, string b) {
	int count = 0;

	int M = a.length();
	for(int i = 0; i < M; i++) {
		if(a[i] == '1' || b[i] == '1') {
			count++;
		}
	}
	return count;
}

int main() {
	/* Enter your code here. Read input from STDIN. Print output to STDOUT */
	int N, M, i = 0, j = 0, topics, maxTopics = 0, maxGroups = 0;
	string person;

	// Read N => Number of people and M => Number of topics
	cin >> N >> M;
	string * people = new string[N];
	
	// Read topics of each person
	for(int k = 0; k < N; k++) {
		cin >> person;
		//Convert binary string to unsigned long
		people[k] = person;
	}


	while(i < N) {
		j = i + 1;
		while (j > i && j < N) {
			topics = maxTopicCount(people[i], people[j]);
			if(topics > maxTopics) {
				maxTopics = topics;
				maxGroups = 1;
			} else if(topics == maxTopics) {
				maxGroups++;
			}
			j++;
		}
		i++;
	}

	cout << maxTopics << endl << maxGroups;

	return 0;
}

