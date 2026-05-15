class PrefixTree {
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        Boolean isEnd = false;
    }

    TrieNode head;

    public PrefixTree() {
        this.head = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = head;
        for(char c: word.toCharArray()) {
            if (curr.next[c - 'a'] == null) {
                curr.next[c - 'a'] = new TrieNode();
            }
            curr = curr.next[c - 'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode curr = head;
        for(char c: word.toCharArray()) {
            if (curr.next[c - 'a'] == null) {
                return false;
            }
            curr = curr.next[c - 'a'];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = head;
        for(char c: prefix.toCharArray()) {
            if (curr.next[c - 'a'] == null) {
                return false;
            }
            curr = curr.next[c - 'a'];
        }
        return true;
    }
}
