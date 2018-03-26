'''
MinHeap:
    Insertion: O(log(n))
    Removal: O(log(n))
'''
class MinHeap(object):

    def __init__(self):
        self.size = 0
        self.arr = []

    def getLeftChildIndex(self, idx):
        return 2 * n + 1
    
    def getRightChildIndex(self, idx):
        return 2 * n + 2
    
    def getParentIndex(self, idx):
        return (idx - 1) // 2

    def getLeftChild(self, idx):
        return self.arr[self.getLeftChildIndex(idx)]
    
    def getRightChild(self, idx):
        return self.arr[self.getRightChildIndex(idx)]
    
    def getParent(self, idx):
        return self.arr[self.getParentIndex(idx)]

    def hasLeftChild(self, idx):
        return self.getLeftChildIndex(idx) < size
    
    def hasLeftChild(self, idx):
        return self.getLeftChildIndex(idx) < size
    
    def hasRightChild(self, idx):
        return self.getRightChildIndex(idx) < size

    def hasParent(self, idx):
        return self.getParentIndex(idx) >= 0

    def add(self, x):
        self.arr.append(x)
        self.size += 1
        self.heapifyUp()

    def peek(self):
        return self.arr[0]

    def poll(self):
        result = self.arr[0]
        self.arr[0] = self.arr[size - 1]
        self.size -= 1
        self.heapifyDown()
        return result

    def heapifyUp(self):
        idx = size - 1
        while self.hasParent(idx):
            parentIdx = self.getParentIndex(idx)
            if self.arr[idx] < self.arr[parentIdx]:
                self.arr[idx], self.arr[parentIdx] = self.arr[parentIdx], self.arr[idx]
            idx = parentIdx
    
    def heapifyDown(self):
        idx = 0
        while self.hasLeftChild(idx):
            smallerChildIdx = self.getLeftChildIndex(idx)
            if self.hasRightChild(idx) and self.getRightChild(idx) < self.getLeftChild(idx):
            smallerChildIdx = self.getRightChildIndex(idx)
            if self.arr[idx] > self.arr[smallerChildIdx]:
                self.arr[idx], self.arr[smallerChildIdx] = self.arr[smallerChildIdx], self.arr[idx]
                idx = smallerChildIdx

    def heapifyUpRec(self, idx):
        if self.hasParent(idx):
            parentIdx = self.getParentIndex(idx)
            if self.arr[parentIdx] > self.arr[idx]:
                self.arr[parentIdx], self.arr[idx] = self.arr[idx], self.arr[parentIdx]
                self.heapifyUp(parentIdx)
    
    def heapifyDownRec(self, idx):
        if self.hasLeftChild(idx):
            smallerChildIdx = self.getLeftChildIndex(idx)
            if self.hasRightChild(idx) and self.getRightChild(idx) < self.getLeftChild(idx):
                smallerChildIdx = self.getRightChildIndex(idx)
                if self.arr[idx] > self.arr[smallerChildIdx]:
                    self.arr[idx], self.arr[smallerChildIdx] = self.arr[smallerChildIdx], self.arr[idx]
                    self.heapifyDown(smallerChildIdx)

    def __str__(self):
        return 'Heap --> {0}'.format(self.arr)

if __name__ == '__main__':
    h = MinHeap()
    print(h)
    h.add(5)
    print(h)
    h.add(1)
    print(h)
    h.add(3)
    print(h)
    h.add(4)
    print(h)
    h.add(9)
    print(h)
    h.add(0)
    print(h)