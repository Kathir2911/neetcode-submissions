class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int R=matrix.length;
        int C=matrix[0].length;
        int left=0,right=R*C-1;
        while(left<=right){
            int mid=(left+right)/2;
            int row=mid/C;
            int col=mid%C;
            if(matrix[row][col]==target) return true;
            else if(matrix[row][col]>target) right=mid-1;
            else left=mid+1;
        }
        return false;
    }
}
