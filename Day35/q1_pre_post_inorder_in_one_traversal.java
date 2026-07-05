import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
        this.node = node;
        this.state = state;
    }
}

public class Main {

    // Build Tree using Level Order Input
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

    public static void allTraversal(Node root) {

        ArrayList<Integer> preorder = new ArrayList<>();
        ArrayList<Integer> inorder = new ArrayList<>();
        ArrayList<Integer> postorder = new ArrayList<>();

        if (root == null)
            return;

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));

        while (!stack.isEmpty()) {

            Pair top = stack.peek();

            // Preorder
            if (top.state == 1) {

                preorder.add(top.node.data);
                top.state++;

                if (top.node.left != null)
                    stack.push(new Pair(top.node.left, 1));
            }

            // Inorder
            else if (top.state == 2) {

                inorder.add(top.node.data);
                top.state++;

                if (top.node.right != null)
                    stack.push(new Pair(top.node.right, 1));
            }

            // Postorder
            else {

                postorder.add(top.node.data);
                stack.pop();
            }
        }

        System.out.println("Preorder : " + preorder);
        System.out.println("Inorder  : " + inorder);
        System.out.println("Postorder: " + postorder);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /*
        Input Format (Level Order)

        Enter root.
        For every node enter:
        left right

        Use -1 for NULL.
        */

        Node root = buildTree(sc);

        allTraversal(root);
    }
}
