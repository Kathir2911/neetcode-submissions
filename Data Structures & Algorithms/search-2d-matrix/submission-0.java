class Solution {
    private static boolean search(int[] nums,int target){
        int N=nums.length;
        int left=0,right=N-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target) return true;
            else if(nums[mid]<target) left=mid+1;
            else right=mid-1;
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int R=matrix.length,C=matrix[0].length;
        int[] nums=new int[R*C];
        for(int row=0;row<R;row++){
            for(int col=0;col<C;col++){
                nums[row*C+col]=matrix[row][col];
            }
        }
        return search(nums,target);
    }
}
