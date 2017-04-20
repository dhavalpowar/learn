import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class KLargestElements {

    public static int getKLargestSum(int [] arr, int k) {
        int sum = 0;
        PriorityQueue<Integer> kMaxheap = new PriorityQueue<Integer>(k);

        for(int i = 0; i < arr.length; i++) {
            kMaxheap.add(arr[i]);
            if(kMaxheap.size() > k) kMaxheap.remove();
        }

        Iterator<Integer> it = kMaxheap.iterator();

        while(it.hasNext()) {
            int n = it.next();
            System.out.println(n);
            sum = sum + n;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] arr = new int[args.length - 1];

        for(int i = 0; i < args.length - 1; i++) {
            arr[i] = Integer.parseInt(args[i]);
        }

        System.out.println(getKLargestSum(arr, Integer.parseInt(args[args.length - 1])));
    }
}