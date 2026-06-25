import java.util.Scanner;
import java.util.Stack;

public class Main {

    static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int top = stack.pop();

        sortStack(stack);

        insertSorted(stack, top);
    }

    static void insertSorted(Stack<Integer> stack, int element) {

        // Largest element should remain on top
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
            return;
        }

        int top = stack.pop();

        insertSorted(stack, element);

        stack.push(top);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        Stack<Integer> stack = new Stack<>();

        System.out.println("Enter stack elements:");

        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }

        sortStack(stack);

        System.out.println("Sorted Stack (Top to Bottom):");

        Stack<Integer> temp = new Stack<>();

        while (!stack.isEmpty()) {
            System.out.print(stack.peek() + " ");
            temp.push(stack.pop());
        }

        System.out.println();
    }
}
