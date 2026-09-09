class Solution {
    public boolean canPartition(int[] nums) {
        int length = nums.length;
        int target = 0;
        for(int i = 0; i < length; i++){
            target += nums[i];
        }
        if(target % 2 ==1){
            return false;
        }
        target /= 2;

        

        int[] dp = new int[length +1];
        Set<Integer> sums = new HashSet<>();
        sums.add(0);

        for(int i = length - 1; i >= 0; i--){
            Set<Integer> newSums = new HashSet<>();
            for(int sum : sums){
                int newSum = sum + nums[i];
                if(newSum == target){
                    return true;
                }

                if(newSum < target){
                    newSums.add(sum);
                    newSums.add(newSum);
                }
            }

            sums = newSums;
        }
        return false;
    }
}
