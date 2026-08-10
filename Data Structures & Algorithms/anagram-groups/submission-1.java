class Solution {
    private static String convert(String str){
        int[] chars=new int[26];
        for(char ch:str.toCharArray()){
            chars[ch-'a']++;
        }
        return Arrays.toString(chars);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            String nums=convert(str);
            map.putIfAbsent(nums,new ArrayList<>());
            map.get(nums).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
