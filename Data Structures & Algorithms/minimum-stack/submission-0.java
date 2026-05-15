class MinStack {
    List<Integer> stack;
    List<Integer> minStack;
    public MinStack() {
        this.stack = new ArrayList<>();
        this.minStack = new ArrayList<>();
    }
    
    public void push(int val) {
        this.stack.add(val);
        if (this.minStack.isEmpty()){
            this.minStack.add(val);
        } else {
            this.minStack.add(Math.min(val, this.minStack.get(this.minStack.size() - 1)));
        }
    }
    
    public void pop() {
        this.stack.remove(this.stack.size() - 1);
        this.minStack.remove(this.minStack.size() - 1);
    }
    
    public int top() {
        return this.stack.get(this.stack.size() - 1);
    }
    
    public int getMin() {
        return this.minStack.get(this.minStack.size() - 1);
    }
}
