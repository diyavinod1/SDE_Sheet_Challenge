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
    List<Integer> ans=new ArrayList<>();
    public void func(TreeNode root){
        if (root==null) return;
        func(root.left);
        ans.add(root.val);
        func(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        func(root);
        return ans.get(k-1);
    }
}
