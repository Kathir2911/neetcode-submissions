class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> start=new PriorityQueue<>((a,b)->(a[1]-b[1]));
        PriorityQueue<int[]> end=new PriorityQueue<>((a,b)->(a[1]-b[1]));
        for(int[] trip:trips){
            int[] starts=new int[]{trip[0],trip[1]};
            int[] ends=new int[]{trip[0],trip[2]};
            start.offer(starts);
            end.offer(ends);
        }
        int curr=0,currStart=0;
        while(!start.isEmpty()){
            int[] current=start.poll();
            curr+=current[0];
            while(end.peek()[1]<=current[1]){
                curr-=end.peek()[0];
                end.poll();
            }
            if(curr>capacity) return false;
        }
        return true;
    }
}