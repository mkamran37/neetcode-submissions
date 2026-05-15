public class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean word = false;
}

class PrefixTree {
    TrieNode trie;

    public PrefixTree() {
        this.trie = new TrieNode();     
    }

    public void insert(String word) {
        TrieNode trie = this.trie;
        for(char c: word.toCharArray()) {
            if (trie.children[c - 'a'] == null) {
                trie.children[c-'a'] = new TrieNode();
            }
            trie = trie.children[c-'a'];
        }
        trie.word = true;
    }

    public boolean search(String word) {
        TrieNode trie = this.trie;
        for(char c: word.toCharArray()) {
            if (trie.children[c - 'a'] == null) {
                return false;
            }
            trie = trie.children[c - 'a'];
        }
        return trie.word;
    }

    public boolean startsWith(String prefix) {
        TrieNode trie = this.trie;
        for (char c: prefix.toCharArray()) {
            if(trie.children[c - 'a'] == null) {
                return false;
            }
            trie = trie.children[c-'a'];
        }
        return true;
    }
}
