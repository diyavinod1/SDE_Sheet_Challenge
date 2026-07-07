/************************************************************

 Following is the Binary Tree node structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;

     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 }

 ************************************************************/

import java.util.*;

public class Solution {

    static boolean leaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    static void left(TreeNode root, List<Integer> ans) {
        root = root.left;
        while (root != null) {
            if (!leaf(root)) ans.add(root.data);
            root = (root.left != null) ? root.left : root.right;
        }
    }

    static void leaves(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        if (leaf(root)) {
            ans.add(root.data);
            return;
        }
        leaves(root.left, ans);
        leaves(root.right, ans);
    }

    static void right(TreeNode root, List<Integer> ans) {
        Stack<Integer> st = new Stack<>();
        root = root.right;

        while (root != null) {
            if (!leaf(root)) st.push(root.data);
            root = (root.right != null) ? root.right : root.left;
        }

        while (!st.isEmpty())
            ans.add(st.pop());
    }

    public static List<Integer> traverseBoundary(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null) return ans;
        if (!leaf(root)) ans.add(root.data);

        left(root, ans);
        leaves(root, ans);
        right(root, ans);

        return ans;
    }
}
