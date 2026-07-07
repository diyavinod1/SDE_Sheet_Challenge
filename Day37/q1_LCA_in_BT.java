/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean func(TreeNode root,TreeNode target,List<TreeNode> p1){
        if (root==null) return false;
        p1.add(root);
        if (root==target) return true;
        if (func(root.left,target,p1) || func(root.right,target,p1)) return true;
        p1.remove(p1.size()-1);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> p1=new ArrayList<>();
        List<TreeNode> p2=new ArrayList<>();
        func(root,p,p1);
        func(root,q,p2);
        int n=Math.min(p1.size(),p2.size());
        TreeNode ans=null;
        for (int i=0;i<n;i++){
            if (p1.get(i)==p2.get(i))
            ans=p1.get(i);
            else break;
        }
        return ans;
    }
}


/* Solution with no extra space complexity */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null)
            return null;
        if (root==p || root==q)
            return root;
        TreeNode l=lowestCommonAncestor(root.left, p, q);
        TreeNode r=lowestCommonAncestor(root.right, p, q);
        if (l!=null && r!=null)
            return root;
        if (l!=null)
            return l;
        return r;
    }
}
