class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        Map<Integer,Integer> map=new TreeMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<int[]> list=new ArrayList<>();
        for(int key:map.keySet()){
            list.add(new int[]{map.get(key),key});
        }
        Collections.sort(list,(a,b)->Integer.compare(b[0],a[0]));
        int[] result=new int[k];
        for(int idx=0;idx<k;idx++){
            result[idx]=(list.get(idx)[1]);
        }
        return result;
    }
}
