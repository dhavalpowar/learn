from node import BinaryNode

class Node(object):
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

    def insert(self, value):
        if value <= self.data:
            if self.left is None:
                self.left = Node(value)
            else:
                self.left.insert(value)
        else:
            if self.right is None:
                self.right = Node(value)
            else:
                self.right.insert(value)

    def contains(self, value):
        if value == self.data:
            return True
        if value < self.data:
            if self.left is None:
                return False
            else:
                self.left.contains(value)
        elif value > self.data:
            if self.right is None:
                return False
            else:
                self.right.contains(value)
    
    def printInOrder(self):
        if self.left:
            self.left.printInOrder()
        print(self.data)
        if self.right:
            self.right.printInOrder()

if __name__ == '__main__':
    n = Node(10)
    n.insert(5)
    n.insert(15)
    n.insert(1)
    n.insert(2)
    n.printInOrder()
