class Solution {
    private static int[][] dp;
    private static int count(int[] nums,int index,boolean previous){
        if(index==nums.length) return 0;
        int secIndex=previous?1:0;
        if(dp[index][secIndex]!=-1) return dp[index][secIndex];
        int take=count(nums,index+1,false);
        if(!previous){
            take=Math.max(take,count(nums,index+1,true)+nums[index]);
        }
        return dp[index][secIndex]=take;
    }
    public int rob(int[] nums) {
        int N=nums.length;
        dp=new int[N][2];
        for(int idx=0;idx<N;idx++){
            Arrays.fill(dp[idx],-1);
        }
        return count(nums,0,false);
    }
}
