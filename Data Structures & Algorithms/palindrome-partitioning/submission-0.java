class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, result, new ArrayDeque<>());
        return result;
    }

    private void backtrack(String s, int start, List<List<String>> result, Deque<String> tmp) {
        if (start == s.length()) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s.substring(start, end + 1))) {
                tmp.addLast(s.substring(start, end + 1));
                backtrack(s, end + 1, result, tmp);
                tmp.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if(s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}
