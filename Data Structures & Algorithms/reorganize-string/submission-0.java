class Solution {
    public String reorganizeString(String s) {
        int[] freq=new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        int maxIdx=0;
        for(int idx=1;idx<26;idx++){
            if(freq[idx]>freq[maxIdx]){
                maxIdx=idx;
            }
        }
        int maxFreq=freq[maxIdx];
        int N=s.length();
        if(maxFreq>(N+1)/2) return "";
        char[] res=new char[N];
        int idx=0;
        char maxChar=(char)(maxIdx+'a');
        while(freq[maxIdx]>0){
            res[idx]=maxChar;
            idx+=2;
            freq[maxIdx]--;
        }
        for(int jdx=0;jdx<26;jdx++){
            while(freq[jdx]>0){
                if(idx>=N){
                    idx=1;
                }
                res[idx]=(char)(jdx+'a');
                idx+=2;
                freq[jdx]--;
            }
        }
        return new String(res);
    }
}