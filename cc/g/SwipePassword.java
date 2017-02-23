/* package whatever; // don't place package name! */

import java.io.*;
import java.util.HashMap;
import java.lang.NumberFormatException;


class Input {

    private int value;
    private boolean visited;
    private HashMap<Integer, Integer> unreachableInputs;

    public Input(int value, UnreachableInput[] unreachableInputs) {
        this.value = value;
        this.visited = false;
        this.unreachableInputs = new HashMap<Integer, Integer>();
        addUnreachableInputs(unreachableInputs);
    }

    public boolean isVisited() {
        // System.out.println(this.visited);
        return this.visited;
    }

    public void setVisited() {
        this.visited = true;
    }

    public boolean getVisited() {
        return this.visited;
    }

    private void addUnreachableInputs(UnreachableInput[] arr) {
        for (int i = 0; i < arr.length; i++) {
            this.unreachableInputs.put(arr[i].value, arr[i].obstructor);
        }
    }

    public boolean isUnreachable(int val) {
        return this.unreachableInputs.get(val) != null;
    }

    public int getUnreachable(int val) {
        return this.unreachableInputs.get(val) != null ? this.unreachableInputs.get(val) : -1;
    }
}

class UnreachableInput {
    public int value;
    public int obstructor;

    public UnreachableInput(int value, int obstructor) {
        this.value = value;
        this.obstructor = obstructor;
    }
}

public class SwipePassword
{
    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println("isCodeValid: " + isCodeValid(args[0]));
    }

    public static void initializeInputMap(HashMap<Integer, Input> inputMap) {

        inputMap.put(0, new Input(0, new UnreachableInput[] { 
                    new UnreachableInput(2, 1),
                    new UnreachableInput(6, 3),
                    new UnreachableInput(8, 4)
                    }));
        inputMap.put(1, new Input(1, new UnreachableInput[] {
                    new UnreachableInput(7, 4)
                    }));
        inputMap.put(2, new Input(2, new UnreachableInput[] {
                    new UnreachableInput(0, 1),
                    new UnreachableInput(6, 3),
                    new UnreachableInput(8, 4)
                    }));
        inputMap.put(3, new Input(3, new UnreachableInput[] {
                    new UnreachableInput(5, 4)
                    }));
        inputMap.put(4, new Input(4, new UnreachableInput[]{}));
        inputMap.put(5, new Input(5, new UnreachableInput[] {
                    new UnreachableInput(3, 4)
                    }));
        inputMap.put(6, new Input(6, new UnreachableInput[] {
                    new UnreachableInput(0, 3),
                    new UnreachableInput(2, 4),
                    new UnreachableInput(8, 7)
                    }));
        inputMap.put(7, new Input(7, new UnreachableInput[] {
                    new UnreachableInput(1, 4)
                    }));
        inputMap.put(8, new Input(8, new UnreachableInput[] {
                    new UnreachableInput(0, 4),
                    new UnreachableInput(2, 5),
                    new UnreachableInput(6, 7)
                    }));
    }

    public static boolean isCodeValid(String code) {
        if(code.length() < 4) {
            return false;
        }

        //Map that stores visited information and unreachable information
        HashMap<Integer, Input> inputMap = new HashMap<Integer, Input> ();

        //Initialize it
        initializeInputMap(inputMap);

        //Set first as as visited
        inputMap.get(Character.getNumericValue(code.charAt(0))).setVisited();

        try {
            for(int i = 1; i < code.length(); i++) {
                int currentSelection = Character.getNumericValue(code.charAt(i));
                int previousSelection = Character.getNumericValue(code.charAt(i-1));

                //Check for repeated inputs
                if(inputMap.get(currentSelection).isVisited()) {
                    // System.out.println("Checking if its visited.");
                    return false;
                }

                if(inputMap.get(currentSelection).isUnreachable(previousSelection)) {
                    int obstructor = inputMap.get(currentSelection).getUnreachable(previousSelection);
                    //Check if its an obstructor is visited;
                    if((i-2) >= 0 && obstructor >= 0) {
                        if(!(inputMap.get(obstructor).isVisited()))
                        {
                            return false;
                        }
                    }
                    else
                    {
                        return false;
                    }
                }
                inputMap.get(currentSelection).setVisited();
                // System.out.println(inputMap.get(currentSelection).getVisited());
            }
            return true;
        }
        catch(NumberFormatException e) {
            System.out.println("Failed to parse code");
            return false;
        }
        catch(NullPointerException e) {
            System.out.println("Invalid code");
            return false;
        }
    }
}

