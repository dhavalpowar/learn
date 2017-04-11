public class BinarySearch {

    public static int searchRecursive(int n, int [] arr) {
        return search(n, arr, 0, arr.length - 1);
    }

    public static int search(int n, int [] arr, int low, int high) {
        int mid = low + ((high-low) / 2);
        if (low <= high) {
            if(n == arr[mid]) {
                return mid;
            }
            else if (n < arr[mid]) {
                return search(n, arr, low, mid - 1);
            } else {
                return search(n, arr, mid + 1, high);
            }
        }
        else {
            return -1;
        }
    }

    public static int searchIterative(int n, int [] arr) {
        int low  = 0;
        int high = arr.length - 1;
        int mid = 0;

        while (low <= high) {
            mid  = low + ((high - low) / 2);
            if (n == arr[mid]) {
                return mid;
            }
            else if (n < arr[mid]) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String [] args) {
        int [] arr = {1, 4, 5, 6, 7, 8, 9};
        System.out.println(searchRecursive(7, arr));
        System.out.println(searchIterative(8, arr));
    }
}