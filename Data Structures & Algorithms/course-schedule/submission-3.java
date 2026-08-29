class Solution {
    public boolean canFinish(int N, int[][] prerequisites) {
        Deque<Integer> queue=new ArrayDeque<>();
        int[] indegree=new int[N];
        @SuppressWarnings("unchecked")
        List<Integer>[] list=new ArrayList[N];
        for(int idx=0;idx<N;idx++) list[idx]=new ArrayList<>();
        for(int[] course:prerequisites){
            indegree[course[0]]++; 
            //[course,prerequistic] then prerequistic->course
            list[course[1]].add(course[0]);
        }
        int take=0;
        for(int idx=0;idx<N;idx++){
            if(indegree[idx]==0){
                queue.offer(idx);
                take++;
            }
        }
        if(queue.isEmpty()) return false;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int idx=0;idx<size;idx++){
                int current=queue.poll();
                for(int course:list[current]){
                    indegree[course]--;
                    if(indegree[course]==0){
                        queue.offer(course);
                        take++;
                    }
                }
            }
        }
        return take==N;
    }
}
