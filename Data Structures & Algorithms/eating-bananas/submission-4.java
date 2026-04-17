class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       int maxPile = piles[0];
       for(int pile : piles){
        maxPile = Math.max(maxPile, pile);
       }

       int minPile = 1;
       while(minPile <= maxPile){
        int middle = minPile + (maxPile - minPile) / 2;

        long sum = 0;
        for(int pile : piles){
            sum += (pile + middle - 1) / middle;
                if (sum > h) {
                    break;
                }
        }
        if(sum <= h){
            maxPile = middle - 1;
        }else{
            minPile = middle + 1;
        }
       }
        return minPile;
    }
}
