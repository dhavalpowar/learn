import java.util.Stack;

import javafx.scene.shape.Ellipse;

public class ReverseStack{

    public static void main(String []args){

        Stack<Integer> s = new Stack<Integer>();
        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);
        printStack(s);
        System.out.println("---------------");
        sortStack(s);
        printStack(s);
    }

    public static void printStack(Stack<Integer> s) {
        for (Integer i : s) {
            System.out.println(i);
        }
    }

    public static void reverseStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            reverseStack(stack);
            insertIntoBottom(stack, temp);
        }
    }

    public static void insertIntoBottom(Stack<Integer> stack, int n) {
        if(stack.isEmpty()) {
            stack.push(n);
        }
        else {
            int temp = stack.pop();
            insertIntoBottom(stack, n);
            stack.push(temp);
        }
    }

    public static void sortStack(Stack<Integer> stack) {
        if(!stack.isEmpty()) {
            int temp = stack.pop();
            sortStack(stack);
            insertSorted(stack, temp);
        }
    }

    public static void insertSorted(Stack<Integer> stack, int n) {
        if(stack.isEmpty() || n > stack.peek()) {
            stack.push(n);
        }
        else {
            int temp = stack.pop();
            insertSorted(stack, n);
            stack.push(temp);
        }
    }
}

