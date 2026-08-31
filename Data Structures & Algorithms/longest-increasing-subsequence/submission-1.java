class Solution {
    private static int dp[][];
    private static int maxLen(int[] nums,int previous,int index){
        if(index>=nums.length) return 0;
        if(dp[previous+1001][index]!=-1) return dp[previous+1001][index];
        int take=0,notTake=0;
        if(previous<nums[index]) take=maxLen(nums,nums[index],index+1)+1;
        notTake=maxLen(nums,previous,index+1);
        return dp[previous+1001][index]=Math.max(take,notTake);
    }
    public int lengthOfLIS(int[] nums) {
        dp=new int[2002][nums.length];
        for(int idx=0;idx<2001;idx++) Arrays.fill(dp[idx],-1);
        return maxLen(nums,-1001,0);
    }
}
