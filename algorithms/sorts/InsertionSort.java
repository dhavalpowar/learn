import java.util.Arrays;

public class InsertionSort {
	public static void sort(int[] arr) {
		// Edge cases
		if (arr.length == 0 || arr.length == 1) return;

		// Initialize index and temp variables
		int j = 0, temp = arr[0];

		// Loop over all elements in array
		for (int i = 1; i < arr.length; i++) {
			j = i;

			// Iterate backwards until 0, to check if current element is in the right place.
			// If its previous element is greater, swap
			while (j > 0 && arr[j] < arr[j - 1]) {

				// Swap jth and (j-1)th element
				temp = arr[j - 1];
				arr[j - 1] = arr[j];
				arr[j] = temp;
				j = j - 1;
			}
		}
	}

	public static void main (String [] args) {
		int[] arr = new int [args.length];
		for (int i = 0; i < args.length; i++)
			arr[i] = Integer.parseInt(args[i]);
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
