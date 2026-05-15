class Solution {
    private void backTrack(Integer openN, Integer closedN, int n, List<String> result, StringBuilder s) {
        if (openN == closedN && openN == n) {
            result.add(s.toString());
            return;
        }
        if(openN < n) {
            s.append("(");
            backTrack(openN+1, closedN, n, result, s);
            s.deleteCharAt(s.length() - 1);
        }
        if (closedN < openN) {
            s.append(")");
            backTrack(openN, closedN+1, n, result, s);
            s.deleteCharAt(s.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backTrack(0, 0, n, result, new StringBuilder());
        return result;
    }
}
