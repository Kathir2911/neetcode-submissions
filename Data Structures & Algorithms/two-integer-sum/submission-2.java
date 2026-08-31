class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int idx=0;idx<nums.length;idx++){
            int curr=nums[idx];
            int diff=target-curr;
            if(map.containsKey(diff)) return new int[]{map.get(diff),idx};
            map.put(curr,idx);
        }
        return new int[]{-1,-1};
    }
}
