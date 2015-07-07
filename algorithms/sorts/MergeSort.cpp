
#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

class  MergeSort{
    public:
    
    static void sort(int* arr, int len) {
        int* copy = new int[len];
        split(arr, 0, len, copy);
    }

    static void sort_iterative(int* arr, int len) {
        int* copy = new int[len];
        split_iterative(arr, 0, len, copy);
    }
    
    private:

    static void split(int* arr, int begin, int end, int* copy) {
        if((end-begin) < 2) {
            return;
        }
        
        int middle = (begin + end) / 2;
        split(arr, begin, middle, copy);
        split(arr, middle, end, copy);
        merge(arr, begin, middle, end, copy);
        copy_back(copy, begin, end, arr);    
    }

    static void split_iterative(int* arr, int begin, int end, int* copy) {
        for(int width = 1; width < end; width = width * 2) {
            for(int i = 0; i < end; i = i + (width * 2)) {
                merge(arr, i, min(i + width, end), min(end, i + (width * 2)), copy);
            }
            copy_back(copy, begin, end, arr);
        }
    }
    
    static void merge(int * arr, int begin, int middle, int end, int * copy) {
        int ptr_1 = begin;
        int ptr_2 = middle;
        
        for(int i = begin; i < end; i++) {
            if(ptr_1<middle && (ptr_2 >= end || arr[ptr_1] <= arr[ptr_2])) {
                copy[i] = arr[ptr_1];
                ptr_1 += 1;
            } else {
                copy[i] = arr[ptr_2];
                ptr_2 += 1;
            }
        }
    }
    
    static void copy_back(int * copy, int begin, int end, int * arr) {
        for(int i = begin; i < end; i++) {
            arr[i] = copy[i];
        }
    }
};

int main()
{
    int n, r;
    string x;
    cout << "Enter N: ";
    cin >> n;
    cout << "Recursive Algorithm?: ";
    cin >> r;
    int * arr = new int[n];
    for(int i = 0; i < n; i++) {
        cin >> x;
        arr[i] = stoi(x);
    }
    cout << endl << endl;
    if(r) {
        cout << "Recursive" << endl;
        MergeSort::sort(arr, n);
    }
    else
        MergeSort::sort_iterative(arr, n);

    for(int i = 0; i < n; i++) {
        cout << arr[i] << "    ";
    }
    cout << endl;
}