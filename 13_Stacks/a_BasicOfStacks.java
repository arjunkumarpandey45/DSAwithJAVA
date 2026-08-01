
import java.util.Stack;

public class a_BasicOfStacks {

    public static void main(String[] args) {

        // Stack create
        Stack<Integer> stack = new Stack<>();

        // ---------------- PUSH ----------------
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("Stack after push: " + stack);

        // ---------------- PEEK ----------------
        System.out.println("Top Element (Peek): " + stack.peek());

        // ---------------- POP ----------------
        System.out.println("Popped Element: " + stack.pop());
        System.out.println("Stack after pop: " + stack);

        // ---------------- SIZE ----------------
        System.out.println("Size: " + stack.size());

        // ---------------- EMPTY ----------------
        System.out.println("Is Stack Empty? " + stack.empty());

        // ---------------- SEARCH ----------------
        // Position from top (1-based indexing)
        System.out.println("Position of 20: " + stack.search(20));

        // ---------------- CONTAINS ----------------
        System.out.println("Contains 30? " + stack.contains(30));

        // ---------------- GET ----------------
        // Access using index (bottom = index 0)
        System.out.println("Element at index 1: " + stack.get(1));

        // ---------------- SET ----------------
        stack.set(1, 99);
        System.out.println("After set(): " + stack);

        // ---------------- REMOVE ----------------
        stack.remove(0);
        System.out.println("After remove index 0: " + stack);

        // ---------------- ITERATE ----------------
        System.out.print("Using for-each: ");
        for (int num : stack) {
            System.out.print(num + " ");
        }
        System.out.println();

        // ---------------- CLEAR ----------------
        stack.clear();
        System.out.println("After clear(): " + stack);

        // ---------------- EMPTY AGAIN ----------------
        System.out.println("Is Stack Empty? " + stack.empty());
    }
}