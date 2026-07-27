import java.util.*;

class TrieNode {
    TrieNode[] child = new TrieNode[26];
    boolean end = false;
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (node.child[i] == null)
                node.child[i] = new TrieNode();
            node = node.child[i];
        }
        node.end = true;
    }

    boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (node.child[i] == null)
                return false;
            node = node.child[i];
        }
        return node.end;
    }

    boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int i = c - 'a';
            if (node.child[i] == null)
                return false;
            node = node.child[i];
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Trie trie = new Trie();

        int q = sc.nextInt();

        while (q-- > 0) {
            int op = sc.nextInt();

            if (op == 1) {
                String word = sc.next();
                trie.insert(word);
            } else if (op == 2) {
                String word = sc.next();
                System.out.println(trie.search(word));
            } else if (op == 3) {
                String prefix = sc.next();
                System.out.println(trie.startsWith(prefix));
            }
        }

        sc.close();
    }
}
