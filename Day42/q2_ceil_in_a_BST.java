import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Main {

    static Node insert(Node root, int data) {
        if (root == null)
            return new Node(data);

        if (data < root.data)
            root.left = insert(root.left, data);
        else if (data > root.data)
            root.right = insert(root.right, data);

        return root;
    }

    static int findCeil(Node root, int key) {
        int ceil = -1;

        while (root != null) {
            if (root.data == key)
                return root.data;

            if (key > root.data) {
                root = root.right;
            } else {
                ceil = root.data;
                root = root.left;
            }
        }

        return ceil;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node root = null;

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter BST elements:");
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            root = insert(root, value);
        }

        System.out.print("Enter key: ");
        int key = sc.nextInt();

        int ceil = findCeil(root, key);

        if (ceil == -1)
            System.out.println("Ceil does not exist.");
        else
            System.out.println("Ceil = " + ceil);

        sc.close();
    }
}
