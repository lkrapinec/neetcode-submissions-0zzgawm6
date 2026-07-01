class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        Set<Integer> col = new LinkedHashSet<>();
        Set<Integer> posDiag = new HashSet<>();
        Set<Integer> negDiag = new HashSet<>();

        placeQueen(0, result, n, col, posDiag, negDiag);

        return result;
    }
    private void placeQueen(int row, List<List<String>> result, int n,  Set<Integer> col, Set<Integer> posDiag, Set<Integer> negDiag) {

        
        if (col.size() == n) {
            List<String> comb = new ArrayList<>();
            StringBuilder sb = new StringBuilder();


            for(int queenPosition : col){
                for(int i = 0; i < n; i++){
                    if(i == queenPosition){
                        sb.append('Q');
                    }else{
                        sb.append('.');
                    }
                }
                comb.add(sb.toString());
                sb.setLength(0);
            }

            result.add(comb);
        }

        if(row >= n){
            return;
        }

        for (int i = 0; i < n; i++) {
            if(col.contains(i) || posDiag.contains(row - i) || negDiag.contains(row + i)){
                continue;
            }
            col.add(i);
            posDiag.add(row - i);
            negDiag.add(row + i);
            placeQueen(row + 1, result, n, col, posDiag, negDiag);
            col.remove(i);
            posDiag.remove(row - i);
            negDiag.remove(row + i);
        }
    }

}

    // put queen on position, then mark this row and column as unavailable, also mark diagonals
    // find next free position
    // if number of queens is n, then store solution