class Solution {
    public int characterReplacement(String s, int k) {
        int maxFreq=0,N=s.length();
        int left=0;
        int[] chars=new int[128];
        int result=0;
        for(int right=0;right<N;right++){
            chars[s.charAt(right)]++;
            maxFreq=Math.max(maxFreq,chars[s.charAt(right)]);
            int windowSize=right-left+1;
            while(windowSize-maxFreq>k){
                chars[s.charAt(left)]--;
                left++;
                windowSize=right-left+1;
            }
            result=Math.max(result,windowSize);
        }
        return result;
    }
}

