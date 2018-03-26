class LinkedNode(object):

    def __init__(self, val):
        self.val = val
        self.next = None

class BinaryNode(object):

    def __init__(self, val, left=None, right=None):
        self.val, self.left, self.right = val, left, right

class DoublyLinkedNode(object):

    def __init__(self, val, prev=None, next=None):
        self.val, self.prev, self.next = val, prev, next

if __name__ == '__main__':
    pass