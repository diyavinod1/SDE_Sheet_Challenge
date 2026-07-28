import java.util.*;

public class Main {

    // Function to generate all subsequences
    static void generateSubsequences(String str, int index, String current) {

        // Base case
        if (index == str.length()) {
            if (!current.isEmpty()) {
                System.out.println(current);
            }
            return;
        }

        // Include current character
        generateSubsequences(str, index + 1, current + str.charAt(index));

        // Exclude current character
        generateSubsequences(str, index + 1, current);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.next();

        System.out.println("\nAll Possible Subsequences:");

        generateSubsequences(str, 0, "");

        sc.close();
    }
}
