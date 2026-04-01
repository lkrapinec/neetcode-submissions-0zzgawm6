class Solution {
    private static final char dot = '.';
    public boolean isValidSudoku(char[][] board) {
        int boardLength = board.length;
        for(int i = 0; i < boardLength; i++){
            Set<Character> uniqueValuesInRow = new HashSet<>();
            Set<Character> uniqueValuesInColumn = new HashSet<>();
            for(int j = 0; j < boardLength; j++){
                if(board[i][j] != dot){
                    if(uniqueValuesInRow.contains(board[i][j])){
                        return false;
                    }
                    uniqueValuesInRow.add(board[i][j]);
                }

                if(board[j][i] != dot){
                    if(uniqueValuesInColumn.contains(board[j][i])){
                        return false;
                    }
                    uniqueValuesInColumn.add(board[j][i]);
                }               
            }
        }

        Set<Character> uniqueValues = new HashSet<>();
        for(int j = 0; j < boardLength; j += 3){
            uniqueValues = new HashSet<>();
            for(int i = 0; i < boardLength; i++){
                if(i != 0 && i % 3 == 0){
                    uniqueValues = new HashSet<>();
                }
                for(int z = j; z < j+3; z++){
                    if(board[i][z] == dot){
                        continue;
                    }
                    if(uniqueValues.contains(board[i][z])){
                        return false;
                    }
                    uniqueValues.add(board[i][z]);
                }
            }
        }
    return true;
    }
}
