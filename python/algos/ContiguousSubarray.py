import sys

def largestSumSubarray(arr):
    
    arr_length = len(arr)
    largest = -sys.maxsize
    memo = [[0 for i in range(arr_length)] for j in range(arr_length)]

    for i in range(arr_length):
        for j in range(i, arr_length):
            if memo[i][j] != 0:
                largest = max(largest, memo[i][j])
            else:
                memo[i][j] = sum(arr[i:j+1])
                largest = max(largest, memo[i][j])
    
    return largest


print(largestSumSubarray([-2,-1]))