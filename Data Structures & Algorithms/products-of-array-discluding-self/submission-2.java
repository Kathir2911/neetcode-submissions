class Solution {
    public int[] productExceptSelf(int[] nums) {
        int mul=1,zeros=0,N=nums.length,index=-1;
        int[] res=new int[N];
        for(int idx=0;idx<N;idx++){
            if(nums[idx]!=0) mul*=nums[idx];
            else{
                zeros++;
                index=idx;
            }
        }
        if(zeros>1) return res;
        if(zeros==1){
            res[index]=mul;
            return res;
        }
        for(int idx=0;idx<N;idx++){
            res[idx]=mul/nums[idx];
        }
        return res;
    }
}  
