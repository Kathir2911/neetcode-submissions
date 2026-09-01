class Solution {
    public int maxProfit(int[] prices) {
        int result=0;
        for(int idx=1;idx<prices.length;idx++){
            if(prices[idx]>prices[idx-1]){
                result+=(prices[idx]-prices[idx-1]);
            }
        }
        return result;
    }
}