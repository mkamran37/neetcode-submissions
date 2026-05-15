class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(n, 0, 0, "", result);
        return result;
    }

    private void generate(int n, int left, int right, String valid, List<String> r) {
        if (left == right && left == n) {
            r.add(valid);
            return;
        }
        if (left < n) {
            generate(n, left + 1, right, valid + "(", r);
        } 
        if (right < left) {
            generate(n, left, right+1, valid + ")", r);
        }
    }
}
