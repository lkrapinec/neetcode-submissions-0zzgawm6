class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLength = matrix[0].length;
        int rowNums = matrix.length;
        int left = 0;
        int right = rowLength * rowNums - 1;
        
        while (left <= right){
            int middle = left + (right - left) / 2;
            int row = middle / rowLength;
            int col = middle % rowLength;
            if(matrix[row][col] == target){
                return true;
            }
            if(target < matrix[row][col]){
                right = middle - 1;
            }else{
                left = middle + 1;
            }
        }
        return false;
    }
}
