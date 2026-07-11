import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

public class Main {

    static Node predecessor = null;
    static Node successor = null;

    // Insert into BST
    static Node insert(Node root, int data) {
        if (root == null)
            return new Node(data);

        if (data < root.data)
            root.left = insert(root.left, data);
        else if (data > root.data)
            root.right = insert(root.right, data);

        return root;
    }

    // Find predecessor and successor
    static void findPreSuc(Node root, int key) {

        while (root != null) {

            if (key < root.data) {
                successor = root;
                root = root.left;
            }
            else if (key > root.data) {
                predecessor = root;
                root = root.right;
            }
            else {

                // Predecessor
                if (root.left != null) {
                    Node temp = root.left;
                    while (temp.right != null)
                        temp = temp.right;
                    predecessor = temp;
                }

                // Successor
                if (root.right != null) {
                    Node temp = root.right;
                    while (temp.left != null)
                        temp = temp.left;
                    successor = temp;
                }

                return;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        Node root = null;

        System.out.println("Enter BST elements:");

        for (int i = 0; i < n; i++) {
            root = insert(root, sc.nextInt());
        }

        System.out.print("Enter key: ");
        int key = sc.nextInt();

        findPreSuc(root, key);

        if (predecessor != null)
            System.out.println("Inorder Predecessor: " + predecessor.data);
        else
            System.out.println("Inorder Predecessor: NULL");

        if (successor != null)
            System.out.println("Inorder Successor: " + successor.data);
        else
            System.out.println("Inorder Successor: NULL");

        sc.close();
    }
}
