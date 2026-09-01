class Solution {
    public int firstMissingPositive(int[] nums) {
        int expected=1;
        Arrays.sort(nums);
        for(int num:nums){
            if(num<0) continue;
            if(num==expected) expected++;
            else if(num>expected) return expected;
        }
        return expected;
    }
}