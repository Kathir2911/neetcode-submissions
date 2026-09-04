class Solution {
    private static int get(int[] count,int repeated){
        int index=-1,maxCnt=0;
        for(int idx=0;idx<3;idx++){
            if(idx==repeated || count[idx]==0) continue;
            if(maxCnt<count[idx]){
                maxCnt=count[idx];
                index=idx;
            }
        }
        return index;
    }
    public String longestDiverseString(int a, int b, int c) {
        int repeated=-1;
        int[] count={a,b,c};
        StringBuilder res=new StringBuilder();
        while(true){
            int maxChar=get(count,repeated);
            if(maxChar==-1) break;
            res.append((char)(maxChar+'a'));
            count[maxChar]--;
            if(res.length()>1 && res.charAt(res.length()-1)==res.charAt(res.length()-2)){
                repeated=maxChar;
            }
            else repeated=-1;
        }
        return res.toString();
    }
}