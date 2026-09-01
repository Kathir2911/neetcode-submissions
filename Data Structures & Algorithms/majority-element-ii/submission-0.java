class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        for(int num:nums) map.put(num,map.getOrDefault(num,0)+1);
        int maj=(nums.length)/3;
        for(int keys:map.keySet()){
            int value=map.get(keys);
            if(value>maj) list.add(keys);
        }
        return list;
    }
}