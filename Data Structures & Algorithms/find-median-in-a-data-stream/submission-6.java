class MedianFinder {
    private PriorityQueue<Integer> firstHalf;
    private PriorityQueue<Integer> secondHalf;
    public MedianFinder() {
        firstHalf = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        secondHalf = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        firstHalf.offer(num);

        if(firstHalf.size() == 1){
            return;
        }

        if(secondHalf.isEmpty()){
            secondHalf.offer(firstHalf.poll());
            return;
        }

        if(firstHalf.peek() > secondHalf.peek() || firstHalf.size() - 1 > secondHalf.size()){
            secondHalf.offer(firstHalf.poll());
        }

        if(secondHalf.size() > firstHalf.size()){
            firstHalf.offer(secondHalf.poll());
        }
    }
    
    public double findMedian() {
        if(firstHalf.size() > secondHalf.size()){
            return firstHalf.peek();
        }

        return (firstHalf.peek() + secondHalf.peek() + 0.0) / 2;
    }
}

//complexity:  findMedian = O(1), offer and poll are O(logn) so addNum = O(logn), memory O(n)

