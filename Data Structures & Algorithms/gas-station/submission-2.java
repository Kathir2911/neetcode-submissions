class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int N=gas.length;
        int currSum=0,totalSum=0,start=0;
        for(int idx=0;idx<N;idx++){
            currSum+=gas[idx]-cost[idx];
            totalSum+=gas[idx]-cost[idx];
            if(currSum<0){
                start=idx+1;
                currSum=0;
            }
        }   
        if(totalSum<0) return -1;
        return start;
    }
}
