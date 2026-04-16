class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        int lastIndex = nums.length -1;
        for(int i = 0; i <= lastIndex; i++){
            int target = -nums[i];

            int left = i + 1;
            int right = lastIndex;

            while(left < right){
                int sum = nums[left] + nums[right];

                if(target == sum){
                    result.add(List.of(nums[i], nums[left], nums[right]));

                    while((left + 1) <= lastIndex && nums[left] == nums[left + 1]){
                        left++;
                    }
                    left++;

                    while((right -1) >= 0 && nums[right] == nums[right - 1]){
                        right--;
                    }
                    right--;
                } else if(target > sum){
                    left++;
                }else{
                    right--;
                }
            }

            while((i + 1) <= lastIndex && nums[i] == nums[i + 1]){
                i++;
            }
        }
        return result;
    }
}

