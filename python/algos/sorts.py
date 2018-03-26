
def insertion_sort(nums):
    for i in range(1, len(nums)):
        j = i - 1
        ptr = i
        while j >= 0 and nums[ptr] < nums[j]:
            nums[ptr], nums[j] = nums[j], nums[ptr]
            j -= 1
            ptr -= 1

    return nums

def merge_sort(nums):

    def merge(left, right):
        l = []
        p1 = 0
        p2 = 0

        if len(left) == 0:
            return right
        if len(right) == 0:
            return left

        while p1 < len(left) and p2 < len(right):
            if left[p1] < right[p2]:
                l.append(left[p1])
                p1 += 1
            else:
                l.append(right[p2])
                p2 += 1

        if p2 != len(right):
            l.extend(right[p2:])
        if p1 != len(left):
            l.extend(left[p1:])

        return l

    def merge_sort_rec(nums):
        if len(nums) == 0 or len(nums) == 1:
            return nums
        else:
            m = len(nums) // 2

            left = merge_sort_rec(nums[:m])
            right = merge_sort_rec(nums[m:])

            return merge(left, right)

    return merge_sort_rec(nums)

print(merge_sort([5,2,4,0,1,6]))
