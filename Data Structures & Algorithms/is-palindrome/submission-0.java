class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()) {
            if(Character.isLetterOrDigit(c))
            stack.push(c);
        }
        System.out.println(stack);
        for(char c: s.toCharArray()) {
            if(Character.isLetterOrDigit(c)) {
                if(stack.pop() != c) {
                    return false;
                }
            }
        }
        return true;
    }
}
