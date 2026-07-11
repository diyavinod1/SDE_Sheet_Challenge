/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, int low, int high) {

        if (index == preorder.length)
            return null;

        int value = preorder[index];

        if (value < low || value > high)
            return null;

        index++;

        TreeNode root = new TreeNode(value);

        root.left = build(preorder, low, value);
        root.right = build(preorder, value, high);

        return root;
    }
}
