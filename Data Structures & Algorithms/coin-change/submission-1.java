class Solution {
    private static int[] dp;
    private static int minCoins(int[] coins,int amount){
        if(amount==0) return 0;
        if(dp[amount]!=-1) return dp[amount];
        int count=Integer.MAX_VALUE;
        for(int coin:coins){
            if(amount-coin>=0) {
                int result=minCoins(coins,amount-coin);
                if(result!=Integer.MAX_VALUE) count=Math.min(count,1+result);
            }
        }
        return dp[amount]=count;
    }
    public int coinChange(int[] coins, int amount) {
        dp=new int[amount+1];
        Arrays.fill(dp,-1);
        int minCoins=minCoins(coins,amount);
        return minCoins!=Integer.MAX_VALUE?minCoins:-1;
    }
}
