/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Serialize
    public String serialize(TreeNode root) {

        if (root == null)
            return "";

        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {

            TreeNode node = q.poll();

            if (node == null) {
                sb.append("N,");
                continue;
            }

            sb.append(node.val).append(",");

            q.offer(node.left);
            q.offer(node.right);
        }

        return sb.toString();
    }

    // Deserialize
    public TreeNode deserialize(String data) {

        if (data.equals(""))
            return null;

        String[] values = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;

        while (!q.isEmpty()) {

            TreeNode node = q.poll();

            // Left Child
            if (!values[i].equals("N")) {
                node.left = new TreeNode(Integer.parseInt(values[i]));
                q.offer(node.left);
            }
            i++;

            // Right Child
            if (!values[i].equals("N")) {
                node.right = new TreeNode(Integer.parseInt(values[i]));
                q.offer(node.right);
            }
            i++;
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
