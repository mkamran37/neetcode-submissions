class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        genPar(result, "", 0, 0, n);
        return result;
    }

    private void genPar(List<String> result, String validPar, int open, int close, int n) {
        if (open == close && open == n) {
            result.add(validPar);
            return;
        } else {
            if (open < n){
                genPar(result, validPar+"(", open+1, close, n);
            }
            if(close < open){
                genPar(result, validPar+")", open, close+1, n);
            }
        }
    }
}
