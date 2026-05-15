class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        genPar(n, 0, 0, result, "");
        return result;
    }

    private void genPar(int n, int open, int closed, List<String> result, String valid) {
        if (open == closed && open == n) {
            result.add(valid);
            return;
        }
        if (open < n) {
            genPar(n, open + 1, closed, result, valid+"(");
        } if (closed < open) {
            genPar(n, open, closed + 1, result, valid + ")");
        }
    }
}
