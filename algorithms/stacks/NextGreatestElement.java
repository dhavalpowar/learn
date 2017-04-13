import java.util.Stack;
import java.util.Arrays;

class NextGreatestElement {
	public static void main (String[] args) {
        int[] arr = new int[args.length];
		for(int i = 0; i < args.length; i++) {
            arr[i] = Integer.parseInt(args[i]);
        }
        nextGreatestElement(arr);
	}
	
	public static void  nextGreatestElement(int[] arr) {
        if(arr == null || arr.length == 0) throw new NullPointerException();

	    Stack<Integer> s = new Stack<>();
	    s.push(arr[0]);
	    for(int i = 1; i < arr.length; i++) {

            // Set next to the current element
            int next = arr[i];

            // If the stack is not empty
            if (!s.isEmpty()) {

                // Pop the element from top of the stack
                int element = s.pop();

                // While the elements on the top of the stack are smaller than 'next'
                // The next greatest element of all the popped elements is 'next' itself
                // So print it
                while (element < next) {
                    System.out.println(element + " --> " + next);

                    // If the stack is empty break out of the loop.
                    if(s.isEmpty()) {
                        break;
                    }
                    element = s.pop();
                }

                // If the element is greater than the next push it onto the stack.
                if (element > next) {
                    s.push(element);
                }
            }

            // If the stack is empty,
            // it means the nextGreatest of all elements before 'next' have been determined.
            // So push 'next' onto stack.
            s.push(next);
	    }


        // All remaining elements on the stack don't have the next greatest element
        while(s.isEmpty() == false) {
            System.out.println(s.pop() + " --> " + "-1");
        }
	}
}