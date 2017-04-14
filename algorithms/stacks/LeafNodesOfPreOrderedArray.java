import java.util.Stack;
public class LeafNodesOfPreOrderedArray {

    public static void main (String[] args) {
        int[] arr = new int[args.length];
		for(int i = 0; i < args.length; i++) {
            arr[i] = Integer.parseInt(args[i]);
        }
        printLeafNodesOfPreOrderedBST(arr);
	}

    public static void printLeafNodesOfPreOrderedBST (int[] arr) {

        Stack<Integer> parents = new Stack<>();
        int current, next;
        current = next = arr[0];

        for(int i = 0; i < arr.length; i++) {
            next = arr[i];

            if(next < current) {
                parents.push(current);
            }
            else {
                if(!parents.isEmpty() && next > parents.peek()) {
                    System.out.println(current);
                }
                while(!parents.isEmpty() && next > parents.peek()) {
                    current = parents.pop();
                }
            }
            current = next;
        }
        System.out.println(next);
    }
}