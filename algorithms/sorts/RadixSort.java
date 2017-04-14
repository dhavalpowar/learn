import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;;

/**
 * Radix sort to sort elements in an array
 * Can also be used to arrange elements in lexicographical order
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = new int [args.length];
		for (int i = 0; i < args.length; i++)
			arr[i] = Integer.parseInt(args[i]);
		sort(arr);
		System.out.println(Arrays.toString(arr));

    }
    public static void sort(int[] arr) {
        ArrayList<LinkedList<Integer>> q = new ArrayList<LinkedList<Integer>>(10);

        // Initialize LinkedList
        for(int i = 0; i < 10; i++) {
            q.add(i, new LinkedList<Integer>());
        }

        int power = 1;
        boolean higherMsbPresent = true;

        while(higherMsbPresent) {
            higherMsbPresent = false;
            // Remove from array and put in proper buckets of the queue
            for (int i = 0; i < arr.length; i++) {
                int digit = (arr[i] % (int) Math.pow(10, power)) / (int) Math.pow(10, power - 1);
                if(digit > 0) {
                    higherMsbPresent = true;
                }
                q.get(digit).add(arr[i]);
            }

            // Dequeue from each bucket and put it back on the array
            int arrIndex = 0;
            for (int i = 0; i < 10; i++) {
                while(!q.get(i).isEmpty()) {
                    arr[arrIndex] = q.get(i).remove();
                    arrIndex++;
                }
            }

            // Get the next most significant digit
            power++;
        }
    }
}