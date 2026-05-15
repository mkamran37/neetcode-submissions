class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String c: tokens) {
            switch (c) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    continue;
                case "-":
                    int x = stack.pop(), y = stack.pop();
                    stack.push(y - x);
                    continue;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    continue;
                case "/":
                    x = stack.pop(); y = stack.pop();
                    stack.push(y/x);
                    continue;                        
                default:
                    stack.push(Integer.parseInt(c));
            }
        }
        return stack.pop();
    }
}
