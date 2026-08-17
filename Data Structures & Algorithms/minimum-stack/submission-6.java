class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || minStack.peek() >= val){
            minStack.push(val);
        }
    }
    
    public void pop() {
        int val = stack.pop();
        if(minStack.peek() == val){
            minStack.pop();
        }
        
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
        
    }
}
//have two stack, one that have elements, and other that has min element for that element
//if there is a new min element add it two second stack, when poping remove element from the second stack only if it matche the element on first stack
//issue what if there are two min elements in the order, how to determine when to pop from min stack (always add same elements)
//other way is to store indexes instead of the values+

//0 0
//2 1
//1 1