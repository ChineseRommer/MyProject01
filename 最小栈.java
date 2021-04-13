class MinStack {

     Deque<Integer> xStack = new LinkedList<Integer>();
     Deque<Integer> minStack = new LinkedList<Integer>();

    /** initialize your data structure here. */
    public MinStack() {
        //给最小栈初始化，方便后面被覆盖
        minStack.push(Integer.MAX_VALUE);

    }
    
    public void push(int x) {
        xStack.push(x);//数据栈一如既往地push进来
        // if(x < minStack.peek()){
        //     minStack.push(x);//如果比最小栈栈顶元素还小，那就push进来
        // }
        //不管谁大谁小，都要push，只不过push更小的数
        minStack.push(Math.min(minStack.peek(), x));

    }
    
    public void pop() {
        xStack.pop();
        minStack.pop();

    }
    
    public int top() {

        return xStack.peek();
    }
    
    public int getMin() {
        
        return minStack.peek();
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










//  class MinStack {
//     Deque<Integer> xStack;
//     Deque<Integer> minStack;

//     public MinStack() {
//         xStack = new LinkedList<Integer>();
//         minStack = new LinkedList<Integer>();
//         minStack.push(Integer.MAX_VALUE);
//     }
    
//     public void push(int x) {
//         xStack.push(x);
//         minStack.push(Math.min(minStack.peek(), x));
//     }
    
//     public void pop() {
//         xStack.pop();
//         minStack.pop();
//     }
    
//     public int top() {
//         return xStack.peek();
//     }
    
//     public int getMin() {
//         return minStack.peek();
//     }
// }