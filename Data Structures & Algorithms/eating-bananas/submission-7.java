class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int length = piles.length;
        int max = piles[0];
        for(int i = 0; i < length; i++){
            max = Math.max(max, piles[i]);
        }
        int min = (int) Math.ceil((0.0 + max / h) / length);


        int result = max;
        while(min <= max){
            int middle = min + (max - min) / 2;
            int time = 0;
            for(int i = 0; i < length; i++){
                time += Math.ceil((0.0 + piles[i])  / middle);
                if(time > h){
                    break;
                }
            }

            if(time <= h){
                result = middle;
                max = middle - 1;
            }else{
                min = middle + 1;
            }
        }

        return result;
    }
}




//find value somewhere between average amount per pile (h / size) and max pile
//take middle value and check if this can be done with this value, if yes store this as result, and try to find better one (check left side), otherwise check right side