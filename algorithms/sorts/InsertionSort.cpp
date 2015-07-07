#include<iostream>
#include<string>

using namespace std;
class InsertionSort {
	public:
		static void sort(int* arr, int len) {
			if(len <= 1)
				return;

			int j;

			for(int i = 0; i < (len-1); i++) {
				j = i + 1;
				while(j > 0 && arr[j] < arr[j-1]) {
					swap(arr[j], arr[j-1]);
					j--;
				}
			}
		}

	private:
		static void swap(int &a, int &b) {
			int temp = a;
			a = b;
			b = temp;
		}
};

int main() {
	int n;
    string x;
    cout << "Enter N: ";
    cin >> n;
    int * arr = new int[n];
    for(int i = 0; i < n; i++) {
        cin >> x;
        arr[i] = stoi(x);
    }
    cout << endl << endl;
    InsertionSort::sort(arr, n);
    for(int i = 0; i < n; i++) {
        cout << arr[i] << "    ";
    }
    cout << endl;
}