public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> miniStack;

    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new Stack<Integer>();
        this.miniStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack.push(x);
        if(miniStack.isEmpty()){
            miniStack.push(x);
        }else{
            miniStack.push(Math.min(x, miniStack.peek()));
        }
    }
    
    public void pop() {
        stack.pop();
        miniStack.pop();
    }
    
    public int top() {
        return stack.peek();
        
    }
    
    public int getMin() {
        return miniStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */