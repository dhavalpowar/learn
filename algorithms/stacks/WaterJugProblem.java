public class WaterJugProblem {
    
    public static void main(String[] args) {
        System.out.println(
            isPossible(
                Integer.parseInt(args[0]),
                Integer.parseInt(args[1]),
                Integer.parseInt(args[2])
            )
        );
    }

    public static boolean isPossible(int jugOne, int jugTwo, int target) {
        int bigger = jugOne > jugTwo ? jugOne : jugTwo;
        int smaller = bigger == jugOne ? jugTwo : jugOne;

        int gcd = gcd(bigger, smaller);

        if(target >=bigger) return false;
        if(gcd != 1 && target % gcd != 0) return false;
        System.out.println(getSteps(0, bigger, smaller, bigger, target));
        return true;
    }

    public static int getSteps(int j1, int j2, int j1Capacity, int j2Capacity, int target) {
        if (j2 == target) {
            return 1;
        }

        System.out.println(j1 + "/" + j1Capacity + " <-- " + j2 + "/" + j2Capacity);
        
        // Pour Jar j2 into j1
        int toBePoured = (j1Capacity - j1) > j2 ? j2 : (j1Capacity - j1);
        j1 = j1 + toBePoured;
        j2 = j2 - toBePoured;

        System.out.println(j1 + "/" + j1Capacity + " <-- " + j2 + "/" + j2Capacity);
        if (j1 == j1Capacity) {
            j1 = 0;
        }
        if (j2 == 0) j2 = j2Capacity;

        return 1 + getSteps(j1, j2, j1Capacity, j2Capacity, target);

    }

    public static int gcd(int a, int b) {
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }
}