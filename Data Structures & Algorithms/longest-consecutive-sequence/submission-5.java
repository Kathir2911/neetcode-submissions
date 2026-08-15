class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        if(nums.length<=1) return nums.length;
        int maxValue=0,consec=1;
        for(int idx=1;idx<nums.length;idx++){
            if(nums[idx]==nums[idx-1]) continue;
            else if(nums[idx]==nums[idx-1]+1) consec++;
            else{
                maxValue=Math.max(maxValue,consec);
                consec=1;
            }
        }
        return Math.max(maxValue,consec);
    }
}
