class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(n, 0, 0, "", result);
        return result;
    }

    private void generate(int n, int l, int r, String valid, List<String> result) {
        if (l == r && l == n) {
            result.add(valid);
            return;
        }
        if(l < n) {
            generate(n, l+1, r, valid+"(", result);
        } if (r < l) {
            generate(n, l, r+1, valid+")", result);
        }
    }
}
