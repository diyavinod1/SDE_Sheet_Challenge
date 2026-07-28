import java.util.*;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    // Insert a word into Trie
    public void insert(String word) {
        TrieNode node = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            node = node.children[index];
        }

        node.isEnd = true;
    }

    // Check if all prefixes of a word exist
    public boolean checkAllPrefixes(String word) {
        TrieNode node = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            node = node.children[index];

            if (node == null || !node.isEnd) {
                return false;
            }
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of words: ");
        int n = sc.nextInt();

        String[] words = new String[n];

        Trie trie = new Trie();

        System.out.println("Enter the words:");

        for (int i = 0; i < n; i++) {
            words[i] = sc.next().toLowerCase();
            trie.insert(words[i]);
        }

        String answer = "";

        for (String word : words) {
            if (trie.checkAllPrefixes(word)) {

                if (word.length() > answer.length()) {
                    answer = word;
                } else if (word.length() == answer.length()
                        && word.compareTo(answer) < 0) {
                    answer = word;
                }
            }
        }

        if (answer.equals("")) {
            System.out.println("None");
        } else {
            System.out.println("Longest Word: " + answer);
        }

        sc.close();
    }
}
