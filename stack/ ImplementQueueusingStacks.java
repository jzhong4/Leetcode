public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    //在做pop，peek，empty操作时，一定要查stack1，有没有新的点压入，然后再操作。
    private void stack1ToStack2() {
	    if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
	}
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        stack1ToStack2();
        return stack2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        stack1ToStack2();
        return stack2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        stack1ToStack2();
        return stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */