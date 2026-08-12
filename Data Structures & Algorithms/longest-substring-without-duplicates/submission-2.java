class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] chars=new int[128];
        int left=0,maxValue=0;
        for(int right=0;right<s.length();right++){
            chars[s.charAt(right)]++;
            while(chars[s.charAt(right)]>1){
                chars[s.charAt(left)]--;
                left++;
            }
            maxValue=Math.max(maxValue,right-left+1);
        }
        return maxValue;
    }
}
