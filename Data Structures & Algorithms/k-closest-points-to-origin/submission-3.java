class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[2], a[2]));

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int distance = x * x + y * y;

            maxHeap.add(new int[] {x, y, distance});
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        int counter = 0;
        while(!maxHeap.isEmpty()){
            int[] pointWithDist = maxHeap.poll();
            result[counter] = new int[]{pointWithDist[0], pointWithDist[1]};
            counter++;
        }

        return result;
    }
}

// 2,2,8
// 0,2,4
// 2,0,4
