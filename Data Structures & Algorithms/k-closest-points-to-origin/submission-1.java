class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            Comparator.comparing(a -> a[0])
        );

        for(int i = 0; i < points.length; i++){
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            minHeap.offer(new int[]{dist, i});
        }

        int[][] result = new int[k][2];
        for(int i = 0; i < k; i++){
           int index = minHeap.poll()[1];
           result[i] = points[index];
        }

        return result;
        
    }
}

