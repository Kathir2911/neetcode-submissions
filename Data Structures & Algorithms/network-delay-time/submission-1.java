class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] list=new ArrayList[n+1];
        for(int idx=1;idx<=n;idx++){
            list[idx]=new ArrayList<>();
        }
        for(int[] time:times){
            list[time[0]].add(new int[]{time[1],time[2]});
        }
        PriorityQueue<int[]> queue=new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        queue.offer(new int[]{k,0});
        Set<Integer> visited=new HashSet<>();
        int time=0;
        while(!queue.isEmpty()){
            int[] curr=queue.poll();
            int node=curr[0],weight=curr[1];
            if(visited.contains(node)) continue;
            visited.add(node);
            time=weight;
            for(int[] neighbor:list[node]){
                if(visited.contains(neighbor[0])) continue;
                queue.offer(new int[]{neighbor[0],neighbor[1]+weight});
            }
        }
        return visited.size()==n?time:-1;
    }
}
