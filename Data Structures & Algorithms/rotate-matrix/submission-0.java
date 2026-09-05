class Solution {
    public void rotate(int[][] matrix) {
        int R=matrix.length,C=matrix[0].length;
        for(int row=0;row<R;row++){
            for(int col=row+1;col<C;col++){
                int temp=matrix[row][col];
                matrix[row][col]=matrix[col][row];
                matrix[col][row]=temp;
            }
        }
       for(int row=0;row<R;row++){
            for(int col=0;col<C/2;col++){
                int temp=matrix[row][col];
                matrix[row][col]=matrix[row][C-col-1];
                matrix[row][C-col-1]=temp;
            }
        }
    }
}
