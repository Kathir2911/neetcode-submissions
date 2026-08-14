class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows=new HashSet[9];
        Set<Character>[] cols=new HashSet[9];
        Set<Character>[] boxes=new HashSet[9];
        for(int idx=0;idx<9;idx++){
            rows[idx]=new HashSet<>();
            cols[idx]=new HashSet<>();
            boxes[idx]=new HashSet<>();
        }
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                if(board[row][col]=='.') continue;
                if(rows[row].contains(board[row][col])) return false;
                if(cols[col].contains(board[row][col])) return false;
                int boxCal=(row/3)*3+(col/3);
                if(boxes[boxCal].contains(board[row][col])) return false;
                boxes[boxCal].add(board[row][col]);
                rows[row].add(board[row][col]);
                cols[col].add(board[row][col]);
            }
        }
        return true;
    }
}
