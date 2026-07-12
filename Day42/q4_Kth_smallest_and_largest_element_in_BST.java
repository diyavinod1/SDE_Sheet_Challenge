import java.util.*;

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

    static int count = 0;
    static int ans = -1;

    // Inorder Traversal -> Kth Smallest
    static void kthSmallest(Node root, int k) {
        if (root == null || count >= k)
            return;

        kthSmallest(root.left, k);

        count++;
        if (count == k) {
            ans = root.data;
            return;
        }

        kthSmallest(root.right, k);
    }

    // Reverse Inorder Traversal -> Kth Largest
    static void kthLargest(Node root, int k) {
        if (root == null || count >= k)
            return;

        kthLargest(root.right, k);

        count++;
        if (count == k) {
            ans = root.data;
            return;
        }

        kthLargest(root.left, k);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Node root = null;

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter BST elements:");
        for (int i = 0; i < n; i++) {
            root = insert(root, sc.nextInt());
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        if (k <= 0 || k > n) {
            System.out.println("Invalid value of k");
            return;
        }

        count = 0;
        ans = -1;
        kthSmallest(root, k);
        int smallest = ans;

        count = 0;
        ans = -1;
        kthLargest(root, k);
        int largest = ans;

        System.out.println("Kth Smallest = " + smallest);
        System.out.println("Kth Largest = " + largest);

        sc.close();
    }
}
