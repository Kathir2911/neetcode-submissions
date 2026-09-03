class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int N=nums.length;
        PriorityQueue<int[]> queue=new PriorityQueue<>((a,b)->b[0]-a[0]);
        int[] res=new int[N-k+1];
        int start=0;
        for(int right=0;right<N;right++){
            queue.offer(new int[]{nums[right],right});
            while(!queue.isEmpty() && queue.peek()[1]<=right-k) queue.poll();
            if(right+1>=k){
                res[start++]=queue.peek()[0];
            }
        }
        return res;
    }
}
