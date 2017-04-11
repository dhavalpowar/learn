import java.util.Map;
import java.util.HashMap;

/**
 * ababbbcc, abc
 */
public class SubstringAlphabet {

    public static void main (String [] args) {
        System.out.println(args[0]);
        System.out.println(substr(args[0], args[1]));
    }

    public static String substr(String s, String t) {
        Map<Character, Boolean> alphabetMap = new HashMap<Character, Boolean>();
        resetAlphabetMap(alphabetMap, t);
        int alphabetLen = t.length();
        int begin = 0;
        int end = begin + alphabetLen - 1;
        int visited = 0;

        while (end < s.length()) {
            if(alphabetMap.get(s.charAt(begin + visited)) != null &&
               alphabetMap.get(s.charAt(begin + visited)) == false) {
                   alphabetMap.put(s.charAt(begin + visited), true);
                   visited++;
                   if(begin + visited - 1 == end) {
                       return s.substring(begin, end+1);
                   }
            } else {
                System.out.println("ELSE ");
                begin = begin + 1;
                end = end + 1;
                visited = 0;
                resetAlphabetMap(alphabetMap);
            }
        }

        return null;
    }


    public static void resetAlphabetMap(Map<Character, Boolean> m) {
        for(Map.Entry<Character, Boolean> entry : m.entrySet()) {
            m.put(entry.getKey(), false);
        }
    }

    public static void resetAlphabetMap(Map<Character, Boolean> m, String alphabet) {
        for(int i = 0; i < alphabet.length(); i++) {
            m.put(alphabet.charAt(i), false);
        }
    }
}