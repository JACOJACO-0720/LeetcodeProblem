class MinStack {
    Stack<Integer> stk = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        stk.push(val);
        if(minStack.isEmpty()||minStack.peek()>=val){
            minStack.push(val);
        }
    }
    
    public void pop() {
        if(stk.isEmpty()){
            return;
        }
        int temp = stk.pop();
        if(minStack.peek()==temp){
            minStack.pop();
        }
        
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */