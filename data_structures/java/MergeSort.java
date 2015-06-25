public class MergeSort {

	/**
	 * The main sorting function
	 * Time - O(nlog(n))
	 * Space - O(n)
	 */
	public static void sort(int [] A, int [] B, int n, boolean recursive) {
		if(recursive)
			split(A, 0, n , B);
		else
			splitIterative(A,n,B);
	}

	/**
	 * Recursive function that splits the array - O(log(n))
	 */
	public static void split(int [] A, int begin, int end, int [] B) {
		if(end-begin < 2) {
			return;
		}

		int middle = (begin + end)/2;
		split(A, begin, middle, B);
		split(A, middle, end, B);
		merge(A, begin, middle, end, B);
		copy(B, begin, end, A);
	}

	/**
	 * Iterative function to split the array - O(log(n))
	 */
	public static void splitIterative(int [] A, int n, int [] B) {
		for(int width = 1; width < n; width = width * 2) {
			for(int i = 0; i < n; i = i + width * 2) {
				merge(A, i, Math.min(i + width, n),Math.min(i + 2 * width, n), B);
			}
			copy(B, 0, n, A);
		}
	}

	/**
	 * The merging function - O(n)
	 */
	public static void merge(int [] A, int begin, int middle, int end, int [] B) {
		//Pointers pointing at current elements in the two arrays
		int p1 = begin, p2 = middle;
		for(int i = begin; i < end; i++) {
			//Check if pointer 1 is less than middle
			//and 2 hasn't reached the end
			//and value at pointer 1 is greater than element at pointer 2
			if(p1 < middle && (p2 >= end || A[p1] <= A[p2])) {
				B[i] = A[p1];
				p1 = p1 + 1;
			} else {
				B[i] = A[p2];
				p2 = p2 + 1;
			}
		}
	}

	/**
	 * Copy array values back
	 */
	public static void copy(int [] B, int begin, int end, int [] A) {
		for(int i = begin; i < end; i++) {
			A[i] = B[i];
		}
	}

	public static void main(String [] args) {
		int [] arr = new int [args.length];
		for(int i = 0; i < args.length - 1; i++) {
			arr[i] = Integer.parseInt(args[i]);
		}
		int [] arr2 = new int[arr.length-1];
		if(Integer.parseInt(args[args.length-1]) != 0) {
			sort(arr, arr2, arr.length-1, true);
		} else {
			sort(arr, arr2, arr.length-1, false);
		}

		System.out.println(java.util.Arrays.toString(arr));
	}
}