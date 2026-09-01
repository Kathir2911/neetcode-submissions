class Solution {
    public int firstMissingPositive(int[] nums) {
        int N=nums.length;
        boolean[] res=new boolean[N+2];
        for(int num:nums){
            if(num<0 || num>N) continue;
            res[num]=true;
        }
        for(int idx=1;idx<N+2;idx++){
            if(!res[idx]) return idx;
        }
        return -1;
    }
}