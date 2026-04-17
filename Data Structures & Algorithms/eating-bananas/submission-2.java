class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       int maxPile = piles[0];
       for(int i = 1; i < piles.length; i++){
        maxPile = Math.max(maxPile, piles[i]);
       }

       int minPile = 1;
       int k = -1;

       while(minPile <= maxPile){
        int middle = minPile + (maxPile - minPile) / 2;

        int sum = 0;
        for(int i = 0; i < piles.length; i++){
            sum += Math.ceil(piles[i] * 1.0 / middle);
        }
        if(sum <= h){
            k = middle;
            maxPile = middle - 1;
        }else{
            minPile = middle + 1;
        }
       }
        return k;
    }
}
