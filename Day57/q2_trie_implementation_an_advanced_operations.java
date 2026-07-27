import java.util.*;

class TrieNode {
    TrieNode[] child = new TrieNode[26];
    int prefixCount = 0;
    int endCount = 0;
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
            node.prefixCount++;
        }
        node.endCount++;
    }

    int countWordsEqualTo(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (node.child[i] == null)
                return 0;
            node = node.child[i];
        }
        return node.endCount;
    }

    int countWordsStartingWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int i = c - 'a';
            if (node.child[i] == null)
                return 0;
            node = node.child[i];
        }
        return node.prefixCount;
    }

    void erase(String word) {
        if (countWordsEqualTo(word) == 0)
            return;

        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            node = node.child[i];
            node.prefixCount--;
        }
        node.endCount--;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Trie trie = new Trie();

        int q = sc.nextInt();

        while (q-- > 0) {
            int op = sc.nextInt();

            switch (op) {
                case 1:
                    trie.insert(sc.next());
                    break;

                case 2:
                    System.out.println(trie.countWordsEqualTo(sc.next()));
                    break;

                case 3:
                    System.out.println(trie.countWordsStartingWith(sc.next()));
                    break;

                case 4:
                    trie.erase(sc.next());
                    break;
            }
        }

        sc.close();
    }
}
