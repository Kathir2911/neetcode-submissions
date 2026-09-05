class Solution {
    public int[] plusOne(int[] digits) {
        int counter=1;
        int N=digits.length;
        for(int idx=N-1;idx>=0;idx--){
            digits[idx]+=counter;
            if(digits[idx]==10){
                digits[idx]=0;
            }
            else counter=0;
        }
        if(counter==1){
            int[] res=new int[N+1];
            for(int idx=0;idx<N;idx++){
                res[idx+1]=digits[idx];
            }
            res[0]=counter;
            return res;
        }
        return digits;
    }
}
