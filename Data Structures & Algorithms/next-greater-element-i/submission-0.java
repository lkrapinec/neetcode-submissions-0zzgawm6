class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> mapTo = new HashMap<>();
        int[] result = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            result[i] = -1;
            for(int j = 0; j < nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    mapTo.put(j, i);
                    break;
                }
            }
        }

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < nums2.length; i++){
            while(!stack.isEmpty() && nums2[stack.peek()] < nums2[i]){

                Integer ind1 = mapTo.get(stack.pop());
                if(ind1 != null){
                    result[ind1] = nums2[i];
                }
                
            }

            if(stack.isEmpty() || nums2[stack.peek()] > nums2[i]){
                stack.push(i);
            }
        }
    
        return result;
    }
}