import java.util.HashSet;

public class StringsInEncodedAlphabet {

    public static int getStringCount(String s) {
        int[] cache = new int[s.length()];
        int count = 1;
        
        for(int i = 1; i < s.length(); i++) {
            int currentAndPrev = Integer.parseInt(s.substring(i-1, i + 1));
            if(currentAndPrev > 9 && currentAndPrev <= 26) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(getStringCount(args[0]));
    }
}