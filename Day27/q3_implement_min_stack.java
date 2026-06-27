class MinStack {
    Stack <Integer> st=new Stack<>();
    Stack <Integer> mist=new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int value) {
        st.push(value);
        if (mist.isEmpty() || value<=mist.peek()) {
            mist.push(value);
        }
    }
    
    public void pop() {
        int x=st.pop();
        if (x==mist.peek()) {
            mist.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return mist.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
