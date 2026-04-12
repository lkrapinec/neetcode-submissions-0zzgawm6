class MinStack {
    private List<Integer> list;
    private List<Integer> minValues;

    public MinStack() {
        list = new LinkedList<>();
        minValues = new LinkedList<>();
    }
    
    public void push(int val) {
        list.addLast(val);

        if(minValues.isEmpty()){
            minValues.addLast(val);
        }else {
            int minValue = Math.min(minValues.getLast(), val);
            minValues.addLast(minValue);
        }
       
    }
    
    public void pop() {
        list.removeLast();
        minValues.removeLast();    
    }
    
    public int top() {
        return list.getLast();
    }
    
    public int getMin() {
        return minValues.getLast();
    }
}
