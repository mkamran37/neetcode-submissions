class TrieNode {
    TrieNode[] node = new TrieNode[26];
    boolean isEnd = false;
}

class PrefixTree {
    TrieNode node;

    public PrefixTree() {
        node = new TrieNode();     
    }

    public void insert(String word) {
        TrieNode ptr = node;
        for (char c: word.toCharArray()) {
            if (ptr.node[c - 'a'] == null) {
                ptr.node[c - 'a'] = new TrieNode();
            }
            ptr = ptr.node[c - 'a'];
        }
        ptr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode ptr = node;
        for (char c: word.toCharArray()) {
            if (ptr.node[c - 'a'] == null) {
                return false;
            }
            ptr = ptr.node[c - 'a'];
        }
        return ptr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = node;
        for (char c: prefix.toCharArray()) {
            if (curr.node[c - 'a'] == null) {
                return false;
            }
            curr = curr.node[c-'a'];
        }
        return true;
    }
}
