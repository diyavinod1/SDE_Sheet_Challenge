class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[2];
    }

    TrieNode root = new TrieNode();

    private void insert(int num) {
        TrieNode node = root;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;

            if (node.child[bit] == null)
                node.child[bit] = new TrieNode();

            node = node.child[bit];
        }
    }

    private int getMaxXor(int num) {
        TrieNode node = root;
        int ans = 0;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int opposite = bit ^ 1;

            if (node.child[opposite] != null) {
                ans |= (1 << i);
                node = node.child[opposite];
            } else {
                node = node.child[bit];
            }
        }

        return ans;
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {

        Arrays.sort(nums);

        int m = queries.length;

        int[][] offline = new int[m][3];

        for (int i = 0; i < m; i++) {
            offline[i][0] = queries[i][0]; // xi
            offline[i][1] = queries[i][1]; // mi
            offline[i][2] = i;             // original index
        }

        Arrays.sort(offline, (a, b) -> Integer.compare(a[1], b[1]));

        int[] ans = new int[m];

        int idx = 0;

        for (int[] q : offline) {

            int xi = q[0];
            int mi = q[1];
            int original = q[2];

            while (idx < nums.length && nums[idx] <= mi) {
                insert(nums[idx]);
                idx++;
            }

            if (idx == 0)
                ans[original] = -1;
            else
                ans[original] = getMaxXor(xi);
        }

        return ans;
    }
}
