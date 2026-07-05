import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

public class Main {

    // Build tree using Level Order Input
    public static Node buildTree(Scanner sc) {

        int val = sc.nextInt();

        if (val == -1)
            return null;

        Node root = new Node(val);

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            Node curr = queue.poll();

            int left = sc.nextInt();

            if (left != -1) {
                curr.left = new Node(left);
                queue.offer(curr.left);
            }

            int right = sc.nextInt();

            if (right != -1) {
                curr.right = new Node(right);
                queue.offer(curr.right);
            }
        }

        return root;
    }

    public static boolean findPath(Node root, int target, ArrayList<Integer> path) {

        if (root == null)
            return false;

        path.add(root.data);

        if (root.data == target)
            return true;

        if (findPath(root.left, target, path) ||
            findPath(root.right, target, path))
            return true;

        // Backtrack
        path.remove(path.size() - 1);

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /*
         Input Format (Level Order)

         Example:
         1
         2 3
         4 5
         -1 -1
         -1 -1
         7 -1
         -1 -1
         7

         Last input is the target node.
        */

        Node root = buildTree(sc);

        int target = sc.nextInt();

        ArrayList<Integer> path = new ArrayList<>();

        if (findPath(root, target, path))
            System.out.println(path);
        else
            System.out.println("Node not found");
    }
}
