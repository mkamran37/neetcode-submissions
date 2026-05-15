public class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean end = false;
}
class PrefixTree {
    TrieNode node;
    public PrefixTree() {
        node = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = node;
        for (char c: word.toCharArray()) {
            if(curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.end = true;
    }

    public boolean search(String word) {
        TrieNode curr = node;
        for (char c: word.toCharArray()) {
            if (curr.children[c - 'a'] == null) return false;
            curr = curr.children[c - 'a'];
        }
        return curr.end;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = node;
        for (char c: prefix.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c-'a'];
        }
        return true;
    }
}
