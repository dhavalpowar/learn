public class GCD {
    public static void main(String[] args) {
        System.out.println(gcd(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
    }
    public static int gcd(int a, int b) {

        int mod = a % b;

        if (mod == 0) {
            return b;
        }
        return gcd(b, mod);
    }
}