import java.util.*;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    // Count distinct substrings
    public int countDistinctSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            TrieNode node = root;

            for (int j = i; j < s.length(); j++) {
                int index = s.charAt(j) - 'a';

                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                    count++;
                }

                node = node.children[index];
            }
        }

        // +1 for the empty substring
        return count + 1;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String s = sc.next().toLowerCase();

        Trie trie = new Trie();

        int result = trie.countDistinctSubstrings(s);

        System.out.println("Number of Distinct Substrings: " + result);

        sc.close();
    }
}
