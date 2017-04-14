import java.util.Stack;
import java.util.HashSet;
import java.util.HashMap;



public class BalancedParantheses {

    public static HashSet<Character> openingBrackets = new HashSet<Character>() {
        {
            add('(');
            add('{');
            add('[');
        }
    };

    public static HashSet<Character> closingBrackets = new HashSet<Character>() {
        {
            add(')');
            add('}');
            add(']');
        }
    };

    public static HashMap<Character, Character> bracketMap = new HashMap<Character, Character>() {
        {
            put('(', ')');
            put('{', '}');
            put('[', ']');
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }
    };

    public static void main(String[] args) {
        System.out.println(areBalanced(args[0]));
    }

    public static boolean areBalanced(String str) {
        // A char array to store the string
        char[] arr = str.toCharArray();

        // A stack to check for balance of the strings
        Stack<Character> stack = new Stack<>();

        // Loop over paratheses
        for(int i = 0; i < arr.length; i++) {
            // If its an opening bracket, push it onto a stack
            if (openingBrackets.contains(arr[i])) {
                stack.push(arr[i]);
            }
            // If its a closing bracket, check if it has a matching closing bracket
            else if (closingBrackets.contains(arr[i])) {
                // If the stack is already empty that means
                // that either the opening bracket was never added or was previously balanced
                if(stack.isEmpty()) {
                    return false;
                }
                // Pop the top of the stack
                Character tos = stack.pop();

                // compare it to the current char
                if(tos != bracketMap.get(arr[i])) {
                    return false;
                }
            }
        }

        // If the stack is not empty, some opening brackets were not balanced
        if(!stack.isEmpty()) {
            return false;
        }

        // All conditions are satisfied
        return true;
    }
}