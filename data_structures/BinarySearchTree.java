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
        if(root == null) {
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