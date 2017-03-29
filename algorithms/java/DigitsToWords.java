import java.util.Map;
import java.util.HashMap;
import java.lang.StringBuilder;

/**
 * 234 / 10 = 12
 * 123 % 10 = 3
 */
public class DigitsToWords {

    public static final Map<Integer, String> wordMap = initMap();
    public static final Map<Integer, String> tenMultiplierMap = initTenMultiplierMap();

    public static void main(String [] args) {
        System.out.println(convert(Integer.parseInt(args[0])));
    }

    public static String convert(int n) {

        if (n <= 0) return "zero";

        StringBuilder nStr = new StringBuilder(Integer.toString(n));
        StringBuilder result = new StringBuilder();
        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < nStr.length() - 1; i++) {
            int digitIndex = nStr.length() - i;
            if(digitIndex < 3) {
                int subInt = Integer.parseInt(nStr.substring(i));
                String subStr = getUnderHundred(subInt);
                result.append(subStr);
            } else {
                String multiplier = tenMultiplierMap.get(digitIndex);
                if(multiplier != null) {
                    buffer.append(nStr.charAt(i));
                    int subInt = Integer.parseInt(buffer.toString());
                    String subStr = getUnderThousand(subInt);

                    if(subStr != "") {
                        result.append(subStr);
                        result.append(multiplier);
                    }

                    buffer = new StringBuilder();
                } else {
                    buffer.append(nStr.charAt(i));
                }
            }
        }

        return result.toString();
    }

    public static Map<Integer, String> initMap() {
        Map<Integer, String> h = new HashMap<Integer, String>();

        h.put(0, "");
        h.put(1, "one ");
        h.put(2, "two ");
        h.put(3, "three ");
        h.put(4, "four ");
        h.put(5, "five ");
        h.put(6, "six ");
        h.put(7, "seven ");
        h.put(8, "eight ");
        h.put(9, "nine ");
        h.put(10, "ten ");
        h.put(11, "eleven ");
        h.put(12, "twelve ");
        h.put(13, "thirteen ");
        h.put(14, "fourteen ");
        h.put(15, "fifteen ");
        h.put(16, "sixteen ");
        h.put(17, "seventeen ");
        h.put(18, "eighteen ");
        h.put(19, "nineteen ");
        h.put(20, "twenty ");
        h.put(30, "thirty ");
        h.put(40, "fourty ");
        h.put(50, "fifty ");
        h.put(60, "sixty ");
        h.put(70, "seventy ");
        h.put(80, "eighty ");
        h.put(90, "ninety ");
        return h;
    }

    public static Map<Integer, String> initTenMultiplierMap() {
        Map<Integer, String> h = new HashMap<Integer, String>();
        h.put(3, "hundred ");
        h.put(4, "thousand ");
        h.put(7, "million ");
        h.put(10, "billion ");
        return h;
    }

    public static String getUnderHundred(int n) {
        String str;
        if(n > 19) str = wordMap.get(10 * (n / 10)) + wordMap.get(n % 10);
        else str = wordMap.get(n);
        return str;
    }

    public static String getUnderThousand(int n) {
        String str = "";
        if(n / 100 > 0) {
            str = wordMap.get(n / 100) + "hundred ";
            if(n % 100 > 0) {
                str += getUnderHundred(n % 100);
            }
        }
        else {
            str = getUnderHundred(n % 100);
        }
        return str;
    }

}