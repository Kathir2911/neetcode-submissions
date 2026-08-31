class Solution {
    public int trap(int[] height) {
        if(height.length==0 || height==null) return 0;
        int N=height.length;
        int result=0;
        int[] prefix=new int[N];
        int[] suffix=new int[N];
        prefix[0]=height[0];suffix[N-1]=height[N-1];
        for(int idx=1;idx<N;idx++){
            prefix[idx]=Math.max(prefix[idx-1],height[idx]);
            suffix[N-idx-1]=Math.max(suffix[N-idx],height[N-idx-1]);
        }
        for(int idx=0;idx<N;idx++){
            result+=Math.min(prefix[idx],suffix[idx])-height[idx];
        }
        return result;
    }
}
