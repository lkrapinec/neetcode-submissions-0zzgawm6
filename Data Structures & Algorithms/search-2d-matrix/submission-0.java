class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int rowIndex = -1;
        int lastRowIndex = matrix[0].length - 1;

        int startRow = 0;
        int endRow = matrix.length - 1;

        while(startRow <= endRow){
            int middle = startRow + (endRow - startRow) / 2;

            if(target >= matrix[middle][0] && target <= matrix[middle][lastRowIndex]){
                rowIndex = middle;
                break;
            }

            if(target < matrix[middle][0]){
                endRow = middle - 1;
            }else{
                startRow = middle + 1;
            }
        }

        if(rowIndex == -1){
            return false;
        }

        int start = 0;
        int end = lastRowIndex;

        while(start <= end){
            int middle = start + (end - start) / 2;

            if(target == matrix[rowIndex][middle]){
                return true;
            }

            if(target > matrix[rowIndex][middle]){
                start = middle + 1;
            }else {
                end = middle - 1;
            }
        }
        return false;
    }
}
