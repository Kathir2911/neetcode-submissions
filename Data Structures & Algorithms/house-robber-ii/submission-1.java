class Solution {
    private static int[][][] dp;
    private static int count(int[] nums,int index,boolean previous,boolean zeroPick){
        if(nums.length==index) return 0;
        if(zeroPick && nums.length-1==index) return 0;
        int secIndex=(previous)?1:0;
        int thirdIndex=(zeroPick)?1:0;
        if(dp[index][secIndex][thirdIndex]!=-1) return dp[index][secIndex][thirdIndex];
        int take=count(nums,index+1,false,zeroPick);
        if(!previous){
            take=Math.max(take,(index==0)?count(nums,index+1,true,true)+nums[index]:count(nums,index+1,true,zeroPick)+nums[index]);
        }
        return dp[index][secIndex][thirdIndex]=take;
    }
    public int rob(int[] nums) {
        int N=nums.length;
        dp=new int[N][2][2];
        for(int idx=0;idx<N;idx++){
            for(int jdx=0;jdx<2;jdx++){
                Arrays.fill(dp[idx][jdx],-1);
            }
        }
        return count(nums,0,false,false);
    }
}
