class KthLargest {
    PriorityQueue<Integer> queue;
    int K;
    public KthLargest(int k, int[] nums) {
        K=k;
        queue=new PriorityQueue<>();
        for(int num:nums) queue.add(num); 
        while(queue.size()>k) queue.poll();
    }
    
    public int add(int val) {
        queue.add(val);
        if(queue.size()>K) queue.poll();
        return queue.peek();
    }
}
