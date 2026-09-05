class Solution {
    public void setZeroes(int[][] matrix) {
        int R=matrix.length,C=matrix[0].length;
        boolean firstRowZero=false, firstColZero=false;
        for(int col=0;col<C;col++){
            if(matrix[0][col]==0){
                firstRowZero=true;
                break;
            }
        }
        for(int row=0;row<R;row++){
            if(matrix[row][0]==0){
                firstColZero=true;
                break;
            }
        }
        for(int row=1;row<R;row++){
            for(int col=1;col<C;col++){
                if(matrix[row][col]==0){
                    matrix[0][col]=0;
                    matrix[row][0]=0;
                }
            }
        }
        for(int row=1;row<R;row++){
            if(matrix[row][0]!=0) continue;
            for(int col=1;col<C;col++){
                matrix[row][col]=0;
            }
        }
        for(int col=1;col<C;col++){
            if(matrix[0][col]!=0) continue;
            for(int row=1;row<R;row++){
                matrix[row][col]=0;
            }
        }
        if(firstRowZero){
            for(int col=0;col<C;col++) matrix[0][col]=0;
        }
        if(firstColZero){
            for(int row=0;row<R;row++) matrix[row][0]=0;
        }
    }
}