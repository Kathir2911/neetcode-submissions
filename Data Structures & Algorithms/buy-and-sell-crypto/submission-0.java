class Solution {
    public int maxProfit(int[] prices) {
        int N=prices.length;
        int minValue=Integer.MAX_VALUE;
        int maxProfit=0;
        for(int idx=0;idx<N;idx++){
            minValue=Math.min(minValue,prices[idx]);
            maxProfit=Math.max(maxProfit,prices[idx]-minValue);
            System.out.println(minValue+" "+maxProfit);
        }
        return maxProfit;
    }
}
