class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
      Arrays.sort(nums);

      List<List<Integer>> result = new ArrayList<>();
      for(int i = 0; i < nums.length - 2;i++){
        int firstNumber = nums[i];
        int left = i+1;
        int right = nums.length -1;

        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum == -firstNumber){
                List<Integer> triplets = new ArrayList<>();
                triplets.add(firstNumber); 
                triplets.add(nums[left]); 
                triplets.add(nums[right]); 

                result.add(triplets);
                 while(right > left && nums[right] == nums[right -1]){
                    right--;
                }
                right--;
            }else if(sum > -firstNumber){
                while(right > left && nums[right] == nums[right -1]){
                    right--;
                }
                right--;
            }else{
                while(left < right && nums[left] == nums[left + 1]){
                    left++;
                }
                left++;
            }
        }
        while (i < nums.length -1 && nums[i] == nums[i+1]){
            i++;
        }
      }

      return result;
    }
}


