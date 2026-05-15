public class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean end = false;
}
class WordDictionary {
    TrieNode node;

    public WordDictionary() {
        node = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = node;
        for (char c: word.toCharArray()) {
            if (curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.end = true;
    }

    public boolean search(String word) {
        return srch(word, 0, node);
    }

    private boolean srch (String word, int start, TrieNode n) {
        TrieNode curr = n;
        for (int i = start; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isLetter(c)) {
                if (curr.children[c - 'a'] == null) return false;
                curr = curr.children[c - 'a'];
            } else {
                for (TrieNode child: curr.children) {
                    if (child != null && srch(word, i + 1, child)) return true;
                }
                return false;
            }
        }
        return curr.end;
    }
}
