class Solution {
    public int lastStoneWeight(int[] stones) {
        int maxStone=0;
        for(int stone:stones) maxStone=Math.max(maxStone,stone);
        int[] bucket=new int[maxStone+1];
        for(int stone:stones) bucket[stone]++;
        int first=maxStone,second=maxStone;
        while(first>0){
            if(bucket[first]%2==0){
                first--;
                continue;
            }
            int jdx=Math.min(first-1,second);
            while(jdx>0 && bucket[jdx]==0) jdx--;
            if(jdx==0) return first;
            second=jdx;
            bucket[first]--;
            bucket[second]--;
            bucket[first-second]++;
            first=Math.max(first-second,second);
        }
        return first;
    }
}
