class MedianFinder {
    PriorityQueue<Integer> bigNumbers;
    PriorityQueue<Integer> smallNumbers;

    public MedianFinder() {
        bigNumbers = new PriorityQueue<>();
        smallNumbers = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
       smallNumbers.offer(num);

       if(smallNumbers.size() - bigNumbers.size() > 1 || !bigNumbers.isEmpty() && smallNumbers.peek() > bigNumbers.peek()){
            bigNumbers.offer(smallNumbers.poll());
       }

       if(bigNumbers.size() - smallNumbers.size() > 1){
            smallNumbers.offer(bigNumbers.poll());
       }
    } 

    public double findMedian() {
        if((smallNumbers.size() + bigNumbers.size()) % 2 == 0){
            return (smallNumbers.peek() + bigNumbers.peek()) / 2.0;
        }
        if(smallNumbers.size() > bigNumbers.size()){
            return smallNumbers.peek();
        }
        return bigNumbers.peek();
    }
}
