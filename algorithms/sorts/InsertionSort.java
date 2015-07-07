import java.util.Arrays;

public class InsertionSort {
	public static void sort(int [] arr) {
		if(arr.length == 0 || arr.length == 1)
			return;
		int j;
		for(int i = 0; i < arr.length-1; i++) {
			
			j = i+1;

			while( j > 0 && arr[j] < arr[j-1]) {
				swap(j, j-1, arr);
				j--;
			}
		}
	}

	public static void swap(int i, int j, int [] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void print(int [] arr) {
		System.out.println(Arrays.toString(arr));
	}
}
