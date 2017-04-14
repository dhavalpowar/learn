import java.util.HashSet;

public class StringAnagram {

    public static void main(String[] args) {
        printAnagramsRec(args[0], "");
    }

    public static void printAnagramsRec(String str, String temp) {
        // If the left hand side string has been reduced to empty
        if(str.length() == 0) {
            // Print the permutation
            System.out.println(temp);
        }

        // For each of the chars in the given string
        // Find the permutation of all other chars against this char.

        for(int i = 0; i < str.length(); i++) {

            String newStr = null;
            if (i == str.length() - 1) {
                newStr = str.substring(0, i);
            } else {
                newStr = str.substring(0, i) + str.substring(i + 1, str.length());
            }
            String newTemp = Character.toString(str.charAt(i)) + temp;
            printAnagramsRec(newStr, newTemp);
        }
    }
}