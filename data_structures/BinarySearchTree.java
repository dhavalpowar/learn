package learn.data_structures;

public class BinarySearchTree {

    /**
     * Inner class that holds a pair of sum and count
     *
     */
    public class SumCountPair {
        int sum, count;

        public SumCountPair(int k) {
            sum = 0;
            this.count = k;
        }

        public SumCountPair(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }

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

    public int sumOfSmallest(int k) {
        SumCountPair p = new SumCountPair(k);
        sumOfSmallest(p, root);
        return p.sum;
    }

    private void sumOfSmallest(SumCountPair p, BinaryNode temp) {
        if(temp.getLeft() != null) sumOfSmallest(p, temp.getLeft());
        if(p.count == 0) {
            return;
        } else {
            p.sum = p.sum + temp.getValue();
            p.count = p.count - 1;
        }
        if(temp.getRight() != null) sumOfSmallest(p, temp.getRight());
    }

    public int greatestCommonAncestor(int a, int b) {
        return gcaHelper(a, b, root).getValue();
    }

    private BinaryNode gcaHelper(int a, int b, BinaryNode temp) {
        if (a < temp.getValue() && b < temp.getValue()) {
            return gcaHelper(a, b, temp.getLeft());
        }
        else if (a > temp.getValue() && b > temp.getValue()) {
            return gcaHelper(a, b, temp.getRight());
        }
        else {
            return temp;
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

    /**
     * Finds the max integer (for a path) between 2 nodes.
     * Soln:- Find GCA and then max(max(gca,a), max(gca, b))
     *
     */
    public int maximElementBetween2Nodes(int a, int b) {
        BinaryNode gca = gcaHelper(a, b, root);
        return Integer.max(
            findMaxBetweenAncestorAndDescendant(gca, a),
            findMaxBetweenAncestorAndDescendant(gca, b)
        );
    }

    /**
     * Finds the max between an ancestor and a descendant.
     *
     */
    private int findMaxBetweenAncestorAndDescendant(BinaryNode gca, int n) {
        int largest = Integer.MIN_VALUE;
        BinaryNode temp = gca;
        while (temp.getValue() != n) {
            int current = temp.getValue();
            largest = current > largest ? current : largest;
            if (current > n) {
                temp = temp.getLeft();
            }
            else {
                temp = temp.getRight();
            }
        }
        return largest;
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
        System.out.println(bst.sumOfSmallest(3));
    }
}