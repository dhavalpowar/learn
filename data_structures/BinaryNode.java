package learn.data_structures;

public class BinaryNode {

    BinaryNode left, right;
    private int data;

    public BinaryNode (int value) {
        data = value;
    }

    public int getValue() {
        return data;
    }

    public void setValue(int value) {
        data = value;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setLeft(BinaryNode n) {
        left = n;
    }

    public void setRight(BinaryNode n) {
        right = n;
    }

    public void insert(int value) {
        if (value <= data) {
            if (left == null) {
                left = new BinaryNode(value);
            }
            else {
                left.insert(value);
            }
            
        }
        else {
            if (right == null) {
                right = new BinaryNode (value);
            }
            else {
                right.insert(value);
            }
        }
    }

    public boolean remove(int value, BinaryNode parent) {
        if (value < data) {
            if (left == null) return false;
            else return left.remove(value, this);
        }
        else if (value > data) {
            if (right == null) return false;
            else return right.remove(value, this);
        }
        else {
            if (left != null && right != null) {
                data = right.getMin();
                right.remove(data, this);
            } else if (parent.left == this) {
                parent.left = (left != null) ? left : right;
            } else if (parent.right == this) {
                parent.right = (left != null) ? left : right;
            }
            return true;
        }
    }

    public boolean contains(int value) {
        if(value == data) {
            return true;
        }
        if(value < data) {
            if(left == null) {
                return false;
            } else {
                return left.contains(value);
            }
        } else {
            if(right == null) {
                return false;
            } else {
                return right.contains(value);
            }
        }
    }

    public int getMin() {
        if(left == null) return data;
        else return left.getMin();
    }

    public int getMax() {
        if(right == null) return data;
        else return right.getMax();
    }

    public void printInOrder() {
        if (left != null) left.printInOrder();
        System.out.println(data);
        if (right != null) right.printInOrder();
    }

    public void printPreOrder() {
        System.out.println(data);
        if (left != null) left.printInOrder();
        if (right != null) right.printInOrder();
    }

    public void printPostOrder() {
        if (left != null) left.printInOrder();
        if (right != null) right.printInOrder();
        System.out.println(data);
    }
}