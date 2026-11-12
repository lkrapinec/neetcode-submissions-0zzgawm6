class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            twoSum(i + 1, -nums[i], nums, result);

            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        return result;
    }

    private void twoSum(int start, int sum, int[] nums, List<List<Integer>> result) {
        int left = start;
        int right = nums.length - 1;

        while (left < right) {
            int currSum = nums[left] + nums[right];
            if (currSum == sum) {
                result.add(List.of(-sum, nums[left], nums[right]));

                left++;
                right--;

                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }

                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }

                

            } else if (currSum < sum) {
                left++;
            } else {
                right--;
            }
        }
    }
}

// does it make sense to first sort the array

//[-4,-1,-1,0,1,2]
// I will pick first number and then look for two other numbers which sum is equal to first num
//
