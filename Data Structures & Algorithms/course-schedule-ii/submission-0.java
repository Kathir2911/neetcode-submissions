class Solution {
    public int[] findOrder(int N, int[][] prerequisites) {
        @SuppressWarnings("unchecked")
        List<Integer>[] list=new ArrayList[N];
        for(int idx=0;idx<N;idx++){
            list[idx]=new ArrayList<>();
        }
        int[] indegree=new int[N];
        int[] res=new int[N];
        Deque<Integer> queue=new ArrayDeque<>();
        for(int[] course:prerequisites){
            indegree[course[0]]++;
            list[course[1]].add(course[0]);
        }
        for(int idx=0;idx<N;idx++){
            if(indegree[idx]==0){
                queue.offer(idx);
            }
        }
        int move=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int idx=0;idx<size;idx++){
                int current=queue.poll();
                res[move++]=current;
                for(int course:list[current]){
                    indegree[course]--;
                    if(indegree[course]==0){
                        queue.offer(course);
                    }
                }
            }
        } 
        return move==N?res:new int[0];
    }
}
