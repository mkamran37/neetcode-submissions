public class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}

class PrefixTree {
    TrieNode root;
    public PrefixTree() {
         this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode tmp = root;
        for(char c: word.toCharArray()) {
            if (tmp.children[c-'a'] == null) {
                tmp.children[c - 'a'] = new TrieNode();
            }
            tmp = tmp.children[c-'a'];
        }
        tmp.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode tmp = root;
        for(char c: word.toCharArray()) {
            if (tmp.children[c - 'a'] == null) {
                return false;
            }
            tmp = tmp.children[c - 'a'];
        }
        return tmp.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode tmp = root;
        for(char c: prefix.toCharArray()) {
            if (tmp.children[c - 'a'] == null) {
                return false;
            }
            tmp = tmp.children[c - 'a'];
        }
        return true;
    }
}
