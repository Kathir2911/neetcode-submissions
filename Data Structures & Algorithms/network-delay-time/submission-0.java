class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        @SuppressWarnings("unchecked")
        List<int[]>[] list=new ArrayList[n+1];
        for(int idx=1;idx<=n;idx++){
            list[idx]=new ArrayList<>();
        }
        for(int[] time:times){
            int source=time[0], end=time[1], cost=time[2];
            list[source].add(new int[]{end,cost});
        }
        PriorityQueue<int[]> queue=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        queue.offer(new int[]{0,k});
        //0--> cost; k-->node
        int time=0;
        Set<Integer> visited=new HashSet<>();
        while(!queue.isEmpty()){
            int[] curr=queue.poll();
            int cost=curr[0],node=curr[1];
            if(visited.contains(node)) continue;
            time=curr[0];
            visited.add(node);
            for(int[] neighbors:list[node]){
                int neighbor=neighbors[0];
                int neighborTime=neighbors[1];
                if(!visited.contains(neighbor)) queue.offer(new int[]{cost+neighborTime,neighbor});
            }
        }
        return visited.size()==n?time:-1;
    }
}
