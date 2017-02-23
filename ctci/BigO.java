public class BigO {
	public static void main(String [] args) {
		switch(args[0]) {
			case "permutations":
				permutations(Integer.parseInt(args[1]));
				break;
			case "fibRec":
				System.out.println(fibRec(Integer.parseInt(args[1])));
		}
		
	}

	public static void permutations(String str) {
		permutations(str, "");
	}

	private static void permutations(String str, String prefix) {
		if (str.length() == 0) {
			System.out.println(prefix);
		}
		else {
			for(int i = 0; i < str.length(); i++) {
				String rem = str.substring(0, i) + str.substring(i + 1);
				permutations(rem, prefix + str.charAt(i));
			}
		}
	}

	public static int fibRec(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		return fibRec(n-1) + fibRec(n-2);
	}
}