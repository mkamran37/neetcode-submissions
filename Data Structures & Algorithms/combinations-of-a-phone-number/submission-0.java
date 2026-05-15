class Solution {
    List<String> result = new ArrayList<>();
    Map<Character, String> map = Map.of(
        '2', "abc",
        '3', "def",
        '4', "ghi",
        '5', "jkl",
        '6', "mno",
        '7', "pqrs",
        '8', "tuv",
        '9', "wxyz"
    );
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return result;
        backtrack(digits, 0, new StringBuilder());
        return result;
    }

    private void backtrack(String digits, int start, StringBuilder sb) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }
        String chars = map.get(digits.charAt(start));
        for (char c: chars.toCharArray()) {
            backtrack(digits, start + 1, sb.append(c));
            sb.deleteCharAt(sb.length() - 1);
        }
        
    }
}
