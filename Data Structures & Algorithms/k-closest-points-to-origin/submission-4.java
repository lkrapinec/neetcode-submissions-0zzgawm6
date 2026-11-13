class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0]* b[0] + b[1]* b[1], a[0]* a[0]+ a[1]* a[1]));

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];

            maxHeap.add(new int[] {x, y});
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        int counter = 0;
        while(!maxHeap.isEmpty()){
            result[counter] = maxHeap.poll();
            counter++;
        }

        return result;
    }
}
