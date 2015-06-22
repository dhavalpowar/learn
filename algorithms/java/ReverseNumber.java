public class ReverseNumber {
	public int reverse(int x) {
		StringBuilder sb = new StringBuilder();
		int digit = 0;
		if(x == 0) {
			return 0;
		}
		if(x < 0) {
			sb.append('-');
		}
		x = Math.abs(x);
		while(x != 0) {
			digit = x % 10;
			sb.append(digit);
			x = x / 10;
		}

		return Integer.parseInt(sb.toString());
	}

	public static void main(String [] args) {
		System.out.println(new ReverseNumber().reverse(1534236469));
	}
}
