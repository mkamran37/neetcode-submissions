class Solution {
    public boolean isPalindrome(String s) {
        Stack<Character> stack = new Stack<>();
        s = s.toLowerCase();
        for(char c: s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                stack.push(c);
            }
        }
        for(char c: s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                if (stack.isEmpty() || c != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
