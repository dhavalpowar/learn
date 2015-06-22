import java.util.HashMap;

public class FindTwoNumbers {
	public static int[] twoSum(int[] numbers, int target) {
		HashMap<Integer,Integer> partialMap = new HashMap<Integer, Integer>();
		int partial;
		int[] result = new int[2];

		for(int i = 0; i < numbers.length; i++) {
			partial = target - numbers[i];
			if(partialMap.get(partial) == null) {
				partialMap.put(numbers[i], i);
			} else {
				result[0] = partialMap.get(partial);
				result[1] = i;
				break;
			}
		}

		return result;
	}

	public static void usage() {
		System.out.println("Usage: FindTwoNumbers <target> <arrSize> <arr[0]> <arr[1]> ... <arr[arrSize-1]>");
		System.exit(1);
	}

	public static void main(String [] args) {
		if(args.length < 3) {
			usage();
		} else if(Integer.parseInt(args[1]) != args.length - 2) {
			usage();
		}
		int[] arr = new int[Integer.parseInt(args[1])];
		for(int i = 2; i < args.length; i++) {
			arr[i-2] = Integer.parseInt(args[i]);
		}
		int target = Integer.parseInt(args[0]);
		int[] result = twoSum(arr, target);
		System.out.println(result[0]+" and "+result[1]);
	}
}
