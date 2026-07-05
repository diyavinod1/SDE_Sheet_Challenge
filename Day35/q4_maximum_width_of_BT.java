class Solution {

    class Pair {
        TreeNode node;
        long index;

        Pair(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        if (root == null)
            return 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        int ans = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            long min = queue.peek().index;

            long first = 0;
            long last = 0;

            for (int i = 0; i < size; i++) {

                Pair curr = queue.poll();

                long idx = curr.index - min;

                if (i == 0)
                    first = idx;

                if (i == size - 1)
                    last = idx;

                if (curr.node.left != null)
                    queue.offer(new Pair(curr.node.left, 2 * idx + 1));

                if (curr.node.right != null)
                    queue.offer(new Pair(curr.node.right, 2 * idx + 2));
            }

            ans = Math.max(ans, (int)(last - first + 1));
        }

        return ans;
    }
}
