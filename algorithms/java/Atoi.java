public class Atoi {
	public int atoi(String str) {

		boolean firstNonSpaceCharFound = false;
		StringBuilder sb =  new StringBuilder();
		if(str.length() == 0) {
			return 0;
		}

		for(int i = 0; i < str.length(); i++) {
			//Leading White spaces
			if(str.charAt(i) == 32 && !firstNonSpaceCharFound){
				continue;
			}
			//Trailing white spacing after an integer
			else if(str.charAt(i) == 32 && firstNonSpaceCharFound){
				break;
			}
			// Dash character at the start of the string
			else if((str.charAt(i) == 45 || str.charAt(i) == 43) && !firstNonSpaceCharFound) {
				System.out.println("this");	
				sb.append(str.charAt(i));
				firstNonSpaceCharFound = true;
			}
			// Any character that represents a digit
			else if(str.charAt(i) > 47 && str.charAt(i) < 58) {
				sb.append(str.charAt(i));
				firstNonSpaceCharFound = true;
			} else {
				return 0;
			}
		}

		if(sb.length() == 1 && sb.charAt(0) == 45) {
			return 0;
		}

		return Integer.parseInt(sb.toString());
	}

	public static void main(String[] args) {
		System.out.println(new Atoi().atoi("+-2"));
	}
}
