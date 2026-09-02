class MedianFinder {
    private PriorityQueue<Integer> firstHalf;
    private PriorityQueue<Integer> secondHalf;
    private int length;
    public MedianFinder() {
        firstHalf = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        secondHalf = new PriorityQueue<>();
        length = 0;
    }
    
    public void addNum(int num) {
        length++;

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
        if(length % 2 == 1){
            return firstHalf.peek();
        }

        return (firstHalf.peek() + secondHalf.peek() + 0.0) / 2;
    }
}

//have two heap, first half in one, and second half in other
//if sum of two length is odd, then return value from the top of the first heap
//otherwise get top of the first and bottom of the second to calculate median
//use maxHeap and min Heap

//how to make sure that heap is balanced
//always offer a new value to maxHeap, if heaps are unbalanced, pop the max heap and add it to the minheap
//if top of max heap is bigger than top of minheap, then rebalance
//if min heap is bigger than max heap, rebalance


//5372

//5 |
//3 5 | -> 3 | 5
//3 7 | 5 -> 3 | 5 7 -> 3 5 | 7
//2 3 5 | 7



