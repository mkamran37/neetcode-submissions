class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(n, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void generate(int n, int open, int close, StringBuilder curr, List<String> result) {
        if (open == n && open == close) {
            result.add(curr.toString());
        }
        if (open < n) {
            curr.append("(");
            generate(n, open + 1, close, curr, result);
            curr.deleteCharAt(curr.length() - 1);
        }
        if (open > close) {
            curr.append(")");
            generate(n, open, close + 1, curr, result);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
