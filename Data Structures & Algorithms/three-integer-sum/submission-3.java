class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
      Arrays.sort(nums);

      List<List<Integer>> result = new ArrayList<>();
      for(int i = 0; i < nums.length - 2;i++){
        if(i > 0 && nums[i] == nums[i-1]){
            continue;
        }

        int firstNumber = nums[i];
        int left = i+1;
        int right = nums.length -1;

        while(left < right){
            int sum = firstNumber + nums[left] + nums[right];
            if(sum == 0){
                List<Integer> triplets = new ArrayList<>();
                triplets.add(firstNumber); 
                triplets.add(nums[left]); 
                triplets.add(nums[right]); 

                result.add(triplets);
                 
                while(left < right && nums[left] == nums[left+1]){
                    left++;
                }
                while(left < right && nums[right] == nums[right-1]){
                    right--;
                }
                right--;
                left++;
            }else if(sum > 0){
                right--;
            }else{
                left++;
            }
        }
      }

      return result;
    }
}


