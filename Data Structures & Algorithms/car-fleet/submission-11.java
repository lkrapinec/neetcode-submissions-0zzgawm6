class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if(position.length == 0){
            return 0;
        }
        int[][] pair = new int[position.length][2];
        for(int i = 0; i < position.length; i++){
            pair[i] = new int[]{position[i], speed[i]};
        }

        Arrays.sort(pair, (a,b) -> Integer.compare(b[0],a[0]));

        int result = 0;
        double maxTime = -1;
        for(int i = 0; i < pair.length; i++){
            double time = (target - pair[i][0] + 0.0) / pair[i][1];
            
            if(time > maxTime){
                maxTime = time;
                result++;
            }
        }

        return result;
    }
}

//8,3,7,4,6,5
//3,4,5,6,7
