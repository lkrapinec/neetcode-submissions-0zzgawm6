class Solution {
    public int[][] merge(int[][] intervals) {
         Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        for(int[] interval : intervals){
            if(!merged.isEmpty() && merged.get(merged.size() - 1)[1] >= interval[0]){
                int[] merge = merged.get(merged.size() - 1);
                merge[1] = Math.max(interval[1], merge[1]);

                merged.remove(merged.size() - 1);

                merged.add(merge);
                continue;
            }

            merged.add(interval);
        }

        int[][] result = new int[merged.size()][2];
        for(int i = 0; i < merged.size(); i++){
            result[i] = merged.get(i);
        }

        return result;
    }
}
