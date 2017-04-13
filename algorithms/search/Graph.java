import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

import javafx.scene.shape.Ellipse;

import java.util.LinkedList;
public class Graph {

    public class Node {

        int data;
        LinkedList<Node> adjacent;

        public Node(int data) {
            this.data = data;
            this.adjacent = new LinkedList<>();
        }
    }

    private HashMap<Integer, Node> nodes = new HashMap<>();

    public void addEdge(int a, int b) {
        Node aNode = null, bNode = null;

        // When both do not exist
        if (nodes.get(a) == null && nodes.get(b) == null) {
            aNode = new Node(a);
            nodes.put(a, aNode);
            bNode = new Node(b);
            nodes.put(b, bNode);
        }
        else if (nodes.get(a) == null) {
            aNode = new Node(a);
            nodes.put(a, aNode);
            bNode = nodes.get(b);
        }
        else if (nodes.get(b) == null) {
            bNode = new Node(b);
            nodes.put(b, bNode);
            aNode = nodes.get(a);
        }
        // When both exist
        else {
            aNode = nodes.get(a);
            bNode = nodes.get(b);
        }

        aNode.adjacent.add(bNode);
        bNode.adjacent.add(aNode);
    }

    public Node getNode(int a) {
        return nodes.get(a);
    }

    public void printNodes() {
        for (Map.Entry<Integer, Node> e : nodes.entrySet()) {
            Node n = e.getValue();
            System.out.print(n.data + " : ");
            for (Node node : n.adjacent) {
                System.out.print(node.data + ", ");
            }
            System.out.println();
        }
    }

    public boolean hasPathDFS(int a, int b) {
        HashSet<Integer> visited = new HashSet<>();
        Node aNode = nodes.get(a);
        Node bNode = nodes.get(b);
        return hasPathDFS(aNode, bNode, visited);
    }

    public boolean hasPathDFS(Node a, Node b, HashSet<Integer> visited) {
        // Do not go down this node is already visited
        if(visited.contains(a.data)) {
            return false;
        }

        visited.add(a.data);

        // Base case
        if (a.data == b.data) {
            return true;
        }

        // For each child run DFS recursively
        for (Node child : a.adjacent) {
            if(hasPathDFS(child, b, visited)) {
                return true;
            }
        }
        return false;
    }

    public void getPathDFS(int a, int b) {
        HashSet<Integer> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        Node aNode = nodes.get(a);
        Node bNode = nodes.get(b);
        stack.push(aNode);
        if(aNode == null || bNode == null) return;
        getPathDFS(aNode, bNode, visited, stack);
        while(!stack.isEmpty()) {
            System.out.print(stack.pop().data + " -->");
        }
    }

    public boolean getPathDFS(Node a, Node b, HashSet<Integer> visited, Stack<Node> stack) {
        // Do not go down this node is already visited
        if(visited.contains(a.data)) {
            return false;
        }

        visited.add(a.data);

        // Base case
        if (a.data == b.data) {
            return true;
        }

        // For each child run DFS recursively
        for (Node child : a.adjacent) {
            stack.push(child);
            if(getPathDFS(child, b, visited, stack)) {
                return true;
            }
            stack.pop();
        }

        return false;
    }

    public static void main(String [] args) {
        Graph g = new Graph();

        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 5);
        g.addEdge(4, 5);
        g.addEdge(1, 5);

        g.printNodes();

        // System.out.println(g.hasPathDFS(1, 5));

        g.getPathDFS(1, 2);
    }
}