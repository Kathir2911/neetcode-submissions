class Solution {
    private static int[][] dp;
    private static int maxCoins(int[] nums,int left,int right){
        if(left+1==right) return 0;
        if(dp[left][right]!=-1) return dp[left][right];
        int max=0;
        for(int k=left+1;k<right;k++){
            int coins=maxCoins(nums,left,k)+maxCoins(nums,k,right)+(nums[left]*nums[k]*nums[right]);
            max=Math.max(max,coins);
        }
        return dp[left][right]=max;
    }
    public int maxCoins(int[] nums) {
        int N=nums.length;
        dp=new int[N+2][N+2];
        for(int idx=0;idx<N+2;idx++){
            Arrays.fill(dp[idx],-1);
        }
        int[] newNums=new int[N+2];
        newNums[0]=newNums[N+1]=1;
        for(int idx=1;idx<=N;idx++){
            newNums[idx]=nums[idx-1];
        }
        return maxCoins(newNums,0,N+1);
    }
}
