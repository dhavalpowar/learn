import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
       int[] arr = new int [args.length];
		for (int i = 0; i < args.length; i++)
			arr[i] = Integer.parseInt(args[i]);
		// sort(arr);
        sort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr)); 
    }
    
    /**
     * Iterative implementation of selectionSort
     */
    public static void sort(int[] arr) {

        //Arr to find max
        for(int i = 0; i < arr.length; i++) {

            // Set minimum to the ith element
            int minIndex = i;

            // Arr to find min
            for(int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap elements on minIndex and ith element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * Recursive implementation of Selection Sort
     */
    public static void sort(int[] arr, int startIndex, int endIndex) {
        if (startIndex > endIndex)
        return;

        int minIdx = getMinIndex(arr, startIndex, endIndex, startIndex);
        System.out.println(minIdx);
        // Swap
        int temp = arr[minIdx];
        arr[minIdx] = arr[startIndex];
        arr[startIndex] = temp;

        sort(arr, startIndex + 1, endIndex);
    }

    /**
     * Recursive findMin function.
     * Just for kicks :-)
     */
    public static int getMinIndex (int[] arr, int start, int end, int minIdx) {
        
        if(start > end) {
            return minIdx;
        }

        if(arr[start] < arr[minIdx]) {
            minIdx = start;
        }

        return getMinIndex(arr, start + 1, end, minIdx);
    }
}