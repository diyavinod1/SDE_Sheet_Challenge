/*********************************************

 Following is the TreeNode class structure

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

 *********************************************/

import java.util.*;

public class Solution {

    static class Pair {
        TreeNode node;
        int hd;

        Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static List<Integer> getTopView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        if (root == null)
            return ans;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {

            Pair curr = q.poll();

            if (!map.containsKey(curr.hd))
                map.put(curr.hd, curr.node.data);

            if (curr.node.left != null)
                q.offer(new Pair(curr.node.left, curr.hd - 1));

            if (curr.node.right != null)
                q.offer(new Pair(curr.node.right, curr.hd + 1));
        }

        for (int val : map.values())
            ans.add(val);

        return ans;
    }
}
