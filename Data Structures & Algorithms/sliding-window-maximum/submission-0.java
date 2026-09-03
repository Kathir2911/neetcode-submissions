class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int N=nums.length;
        int size=N-k+1,start=0;
        int[] res=new int[size];
        Deque<Integer> queue=new ArrayDeque<>();
        for(int right=0;right<N;right++){
            while(!queue.isEmpty() && nums[queue.peekLast()]<=nums[right]) queue.pollLast();
            while(!queue.isEmpty() && queue.peekFirst()<=right-k) queue.pollFirst();
            queue.offerLast(right);
            if(right>=k-1){
                res[start++]=nums[queue.peekFirst()];
            }
        }
        return res;
    }
}
