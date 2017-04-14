
public class InvertBinaryTree {
    public static class Node {

        Node left, right;
        int data;

        public Node (int value) {
            data = value;
        }

        public void printInorder() {
            if(left != null) left.printInorder();
            System.out.print(data + " ");
            if(right != null) right.printInorder();
        }
    }

    public static void invertTree(Node root) {
        if(root == null) {
            return;
        }

        Node temp = root.right;
        root.right = root.left;
        root.left = temp;

        invertTree(root.left);
        invertTree(root.right);
    }
    
    public static void main(String[] args) {
        Node n = new Node(5);
        n.left = new Node(3);
        n.right = new Node(7);
        n.left.left = new Node(1);
        n.left.right = new Node(4);
        n.right.left = new Node(6);
        n.right.right = new Node(8);
        n.printInorder(); // 1 3 4 5 6 7 8
        System.out.println();
        invertTree(n);
        n.printInorder(); // 8 7 6 5 4 3 1
    }
}