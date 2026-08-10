class Solution {
    public boolean isAnagram(String s, String t) {
        int[] chars=new int[26];
        int len1=s.length(),len2=t.length();
        if(len1!=len2) return false;
        for(int idx=0;idx<len1;idx++){
            chars[s.charAt(idx)-'a']++;
            chars[t.charAt(idx)-'a']--;
        }
        for(int val:chars) if(val!=0) return false;
        return true;
    }
}
