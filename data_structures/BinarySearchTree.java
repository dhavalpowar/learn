package learn.data_structures;

public class BinarySearchTree {

    BinaryNode root;

    public BinarySearchTree(int value) {
        root = new BinaryNode(value);
    }

    public void insert(int value) {
        if (root == null) {
            root = new BinaryNode(value);
            return;
        }

        root.insert(value);
    }

    public boolean remove(int value) {
        if (root == null) {
            return false;
        }
        else if (value == root.getValue()) {
            BinaryNode auxRoot = new BinaryNode(0);
            auxRoot.setLeft(root);
            boolean result = root.remove(value, auxRoot);
            root = auxRoot.getLeft();
            return result;
        }
        else {
            return root.remove(value, null);
        }
    }

    public int greatestCommonAncestor(int a, int b) {
        return gcaHelper(a, b, root);
    }

    public int gcaHelper(int a, int b, BinaryNode temp) {
        if (a < temp.getValue() && b < temp.getValue()) {
            return gcaHelper(a, b, temp.getLeft());
        }
        else if (a > temp.getValue() && b > temp.getValue()) {
            return gcaHelper(a, b, temp.getRight());
        }
        else {
            return temp.getValue();
        }
    }

    public int greatestCommonAncestorIter(int a, int b) {

        BinaryNode temp = root;

        while ((a < temp.getValue() && b < temp.getValue()) || (a > temp.getValue() && b > temp.getValue())) {
            if (a < temp.getValue() && b < temp.getValue()) temp = temp.getLeft();
            if (a > temp.getValue() && b > temp.getValue()) temp = temp.getRight();
        }

        return temp.getValue();
    }

    public void print() {
        root.printInOrder();
    }
    
    public static void main (String [] args) {
        BinarySearchTree bst = new BinarySearchTree(Integer.parseInt(args[0]));
        for(int i = 1; i < args.length; i++) {
            bst.insert(Integer.parseInt(args[i]));
        }
        bst.print();
        System.out.println(bst.remove(12));
        bst.print();
    }
}