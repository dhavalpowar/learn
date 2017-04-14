import java.util.HashSet;

public class StringAnagram {

    public static void main(String[] args) {
        printAnagramsRec(args[0], "");
    }

    public static void printAnagramsRec(String str, String temp) {
        if(str.length() == 0) {
            System.out.println(temp);
        }

        for(int i = 0; i < str.length(); i++) {
            int postBeginIdx = i + 1;
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