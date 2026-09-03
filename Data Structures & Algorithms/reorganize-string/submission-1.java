class Solution {
    public String reorganizeString(String s) {
        int N=s.length();
        int[] freq=new int[26];
        int maxFreq=-1,maxIdx=-1;
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
            if(maxFreq<freq[ch-'a']){
                maxFreq=freq[ch-'a'];
                maxIdx=(int)(ch-'a');
            }
        }
        if(maxFreq>(N+1)/2) return "";
        char[] res=new char[N];
        int start=0;
        char maxChar=(char)(maxIdx+'a');
        while(freq[maxIdx]>0){
            res[start]=maxChar;
            start+=2;
            freq[maxIdx]--;
        }
        for(int idx=0;idx<26;idx++){
            while(freq[idx]>0){
                if(start>=N) start=1;
                res[start]=(char)(idx+'a');
                start+=2;
                freq[idx]--;
            }
        }
        return new String(res);
    }
}