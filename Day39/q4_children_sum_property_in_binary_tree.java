import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

public class Main {

    static Scanner sc = new Scanner(System.in);

    // Build Tree (Preorder Input)
    static Node buildTree() {

        int val = sc.nextInt();

        if (val == -1)
            return null;

        Node root = new Node(val);

        root.left = buildTree();
        root.right = buildTree();

        return root;
    }

    // Convert to Children Sum Property
    static void changeTree(Node root) {

        if (root == null)
            return;

        int child = 0;

        if (root.left != null)
            child += root.left.data;

        if (root.right != null)
            child += root.right.data;

        // Top Down
        if (child >= root.data)
            root.data = child;
        else {

            if (root.left != null)
                root.left.data = root.data;

            if (root.right != null)
                root.right.data = root.data;
        }

        changeTree(root.left);
        changeTree(root.right);

        // Bottom Up
        int total = 0;

        if (root.left != null)
            total += root.left.data;

        if (root.right != null)
            total += root.right.data;

        if (root.left != null || root.right != null)
            root.data = total;
    }

    // Level Order Traversal
    static void levelOrder(Node root) {

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {

            Node temp = q.poll();

            System.out.print(temp.data + " ");

            if (temp.left != null)
                q.offer(temp.left);

            if (temp.right != null)
                q.offer(temp.right);
        }
    }

    public static void main(String[] args) {

        System.out.println("Enter tree in preorder (-1 for NULL):");

        Node root = buildTree();

        changeTree(root);

        System.out.println("\nTree after conversion:");

        levelOrder(root);
    }
}
