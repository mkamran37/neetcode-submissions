class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack(s, 0, new ArrayDeque<>());
        return result;
    }

    private void backtrack(String s, int start, Deque<String> dq) {
        if (start == s.length()) {
            result.add(new ArrayList<>(dq));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            String t = s.substring(start, end + 1);
            if (isPalindrome(t)) {
                dq.addLast(t);
                backtrack(s, end + 1, dq);
                dq.removeLast();
            }
        }
    }

    private boolean isPalindrome(String t) {
        int l = 0, r = t.length() - 1;
        while (l < r) {
            if (t.charAt(l++) != t.charAt(r--)) return false;
        }
        return true;
    }
}
