class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[2];
    }

    TrieNode root = new TrieNode();

    // Insert a number into the trie
    private void insert(int num) {
        TrieNode node = root;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;

            if (node.child[bit] == null) {
                node.child[bit] = new TrieNode();
            }

            node = node.child[bit];
        }
    }

    // Find maximum XOR possible with current number
    private int getMaxXor(int num) {
        TrieNode node = root;
        int maxXor = 0;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int opposite = 1 - bit;

            if (node.child[opposite] != null) {
                maxXor |= (1 << i);
                node = node.child[opposite];
            } else {
                node = node.child[bit];
            }
        }

        return maxXor;
    }

    public int findMaximumXOR(int[] nums) {

        // Build Trie
        for (int num : nums) {
            insert(num);
        }

        int ans = 0;

        // Find best XOR for every number
        for (int num : nums) {
            ans = Math.max(ans, getMaxXor(num));
        }

        return ans;
    }
}
