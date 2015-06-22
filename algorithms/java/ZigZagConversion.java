public class ZigZagConversion {
	public static String convert(String s, int nRows) {
		StringBuffer[] sb = new StringBuffer[nRows];
		int inBetweenChars = nRows/2;
		int j = 0;
		for(int i = 0; i < nRows; i++) {
			sb[i] = new StringBuffer();
		}


		while( j < s.length()) {

			//Down columns
			for(int k = 0; k < nRows; k++) {
				if(j < s.length()) {
					sb[k].append(s.charAt(j));
					j++;
				}
			}


			//Up columns
			for(int l = nRows-2; l > 0; l--) {
				if((j) < s.length()) {
					sb[l].append(s.charAt(j));
					j++;
				}
			}
		}

		for(int i = 1; i < sb.length; i++) {
			sb[0].append(sb[i].toString()); 
		}
		return sb[0].toString();
	}

	public static void usage() {
		System.out.println("Usage: java ZigZagConversion <string>  <nRows>");
		System.exit(0);
	}

	public static void main(String [] args) {
		if(args.length < 2) {
			usage();	
		}
		System.out.println(convert(args[0], Integer.parseInt(args[1])));	
	}
}
