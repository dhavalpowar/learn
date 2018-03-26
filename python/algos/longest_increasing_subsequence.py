
def longestSubsequence(arr):

    # [ 5, 3, 4, 8, 6, 7]

    longest_so_far = [1] * (len(arr) + 1)
    longest_at_position = [0] * (len(arr) + 1)
    longest = 1

    for i in range(1, len(arr)):

        if arr[i-1] < arr[i]:
            longest_so_far[i] = longest_so_far[i-1] + 1
        else:
            
