class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int res=0,currSum=0;
        for(int num:nums){
            currSum+=num;
            int diff=currSum-k;
            if(map.containsKey(diff)) res+=map.get(diff);
            map.put(currSum,map.getOrDefault(currSum,0)+1);
        }
        return res;
    }
}