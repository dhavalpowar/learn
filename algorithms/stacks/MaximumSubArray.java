import java.awt.RenderingHints;
import java.lang.Math;

public class MaximumSubArray {

    public static void main(String[] args) {
        int[] arr = new int [args.length];
        for(int i = 0; i < args.length; i++) {
            arr[i] = Integer.parseInt(args[i]);
        }

        Result r = findMaxSubArrayIter(arr);   //findMaxSubArrayRec(arr, 0, arr.length - 1);

        System.out.println("i: " + r.low + "\t j: " + r.high + "\tsum: " + r.sum);
    }
    private static class Result {
        int low;
        int high;
        int sum;

        public Result(int low, int high, int max) {
            this.low = low;
            this.high = high;
            this.sum = max;
        }
    }

    public static Result findMaxSubArrayIter(int[] arr) {
        int max, currentMax;
        max = currentMax = arr[0];

        Result r = new Result(0, 0, currentMax);

        for (int i = 1; i < arr.length; i++) {
            currentMax = Math.max(arr[i], arr[i] + currentMax);
            int tempMax = Math.max(max, currentMax);
            if(currentMax == arr[i]) r.low = i;
            if (tempMax > max) {
                r.high = i;
                r.sum = max = tempMax;
            }
        }

        return r;
    }

    public static Result findMaxSubArrayRec(int[] arr, int low, int high) {
        if(low == high) {
            return new Result(low, high, arr[low]);
        }

        // Divide
        int mid = (low + high) / 2;

        // Conquer
        Result leftMax = findMaxSubArrayRec(arr, low, mid);
        Result rightMax = findMaxSubArrayRec(arr, mid + 1, high);

        // Combine
        Result crossMax = findMaxCrossingSubArray(arr, low, mid, high);

        if(leftMax.sum >= rightMax.sum && leftMax.sum >= crossMax.sum) {
            return leftMax;
        }
        else if (rightMax.sum >= leftMax.sum && rightMax.sum >= crossMax.sum) {
            return rightMax;
        }
        else {
            return crossMax;
        }
    }

    public static Result findMaxCrossingSubArray(int[] arr, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int maxLeft = mid;
        for (int i = mid; i >= low; i--) {
            sum += arr[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }

        int rightSum = Integer.MIN_VALUE;
        int maxRight = mid + 1;
        sum = 0;
        for (int i = mid + 1; i <= high; i++) {
            sum += arr[i];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = i;
            }
        }

        return new Result(maxLeft, maxRight, leftSum + rightSum);
    }
}