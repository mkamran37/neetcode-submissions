public class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}

class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode tmp = root;
        for(char c: word.toCharArray()) {
            if (tmp.children[c - 'a'] == null) {
                tmp.children[c - 'a'] = new TrieNode();
            }
            tmp = tmp.children[c-'a'];
        }
        tmp.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int j, TrieNode start) {
        TrieNode tmp = start;
        for(int i = j; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c == '.') {
                for(TrieNode child: tmp.children) {
                    if (child != null && dfs(word, i+1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (tmp.children[c - 'a'] == null) {
                    return false;
                }
                tmp = tmp.children[c-'a'];
            }
        }
        return tmp.isEnd;
    }
}
