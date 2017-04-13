import java.util.Arrays;
import java.util.Stack;
public class StockSpanProblem {

    /**
     * O(n^2) algorithm
     */
    public static int[] getStockSpan(int[] arr) {

        int[] span  = new int[arr.length];

        span[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            span[i] = 1;
            int j = i - 1;

            while ( j >= 0 && arr[j] <= arr[i]) {
                span[i]++;
                j--;
            }
        }

        return span;
    }

    /**
     * O(n) algorithm - Uses stack
     */
    public static int[] getStockSpanFaster(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        int[] span = new int[arr.length];
        span[0] = 1;
        stack.push(arr[0]);

        // Loop over all elements until end.
        for(int i = 1; i < arr.length; i++) {

            int current = arr[i];

            // Current span for this element is one
            int currentSpan = 1;

            // Pop the top of the stack
            int p = stack.pop();

            // While the current is greater than the top of stack
            while(current > p) {

                // Increment currentSpan
                currentSpan++;

                // Breakout if stack turns empty
                if(stack.isEmpty()) {
                    break;
                }

                // Pop the next element off the stack
                p = stack.pop();
            }

            // If current is less than the top of stack
            if(current < p) {
                // Then the current element's span is currentSpan
                span[i] = currentSpan;
                // Push the last popped element back onto stack
                stack.push(p);
            }
            // If current is greater even after stack is empty
            // currentSpan is 1 + currentSpan;
            else if(current > p && stack.isEmpty()) {
                span[i] = currentSpan + 1;
            }

            // Push the current element onto the stack
            stack.push(current);
        }

        // Return span of all elements
        return span;
    }

    public static void main(String[] args) {
        int[] arr = new int[args.length];
        for(int i = 0; i < args.length; i++) {
            arr[i] = Integer.parseInt(args[i]);
        }

        System.out.println(Arrays.toString(getStockSpan(arr)));
    }
}