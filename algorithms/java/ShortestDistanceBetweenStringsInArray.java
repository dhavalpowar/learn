import java.util.Arrays;

public class ShortestDistanceBetweenStringsInArray {

    /**
     *  a b c a d a
     */
    public static int getShortestDistance(String[] arr, String source, String dest) {

        int minLen = Integer.MAX_VALUE;
        int tempLen = 0;
        boolean destFound = false;
        boolean sourceFound = false;

        for(int i = 0; i < arr.length; i++) {

            if(dest.equals(arr[i]) && !sourceFound) {
                destFound = true;
                tempLen = 0;
                continue;
            }
            if(source.equals(arr[i]) && destFound && !sourceFound) {
                tempLen++;
                sourceFound = true;
                minLen = Math.min(minLen, tempLen);
                tempLen = 0;
                destFound = false;
                continue;
            }
            if(sourceFound && dest.equals(arr[i])) {
                tempLen++;
                minLen = Math.min(minLen, tempLen);
                tempLen = 0;
                destFound = false;
                continue;
            }
            tempLen++;
        }

        return minLen;
    }

    public static void main(String[] args) {
        String[] arr = Arrays.copyOfRange(args, 0, args.length - 2);
        System.out.println(getShortestDistance(arr, args[args.length - 2], args[args.length - 1]));
    }
}