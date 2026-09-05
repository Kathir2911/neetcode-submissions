class Solution {
    private static int[][] dp;
    private static int findCombinations(int[] coins,int amount,int index){
        if(amount==0) return 1;
        if(index==coins.length) return 0;
        if(dp[amount][index]!=-1) return dp[amount][index];
        int take=0,notTake=0;
        if(amount-coins[index]>= 0) take=findCombinations(coins,amount-coins[index],index);
        notTake=findCombinations(coins,amount,index+1);
        return dp[amount][index]=take+notTake;
    }
    public int change(int amount, int[] coins) {
        dp=new int[amount+1][coins.length];
        for(int idx=0;idx<=amount;idx++){
            Arrays.fill(dp[idx],-1);
        }
        return findCombinations(coins,amount,0);
    }
}
