class Solution {
    private static boolean dfs(List<Integer>[] list,boolean[] path,boolean[] visited,int current){
        if(path[current]) return false;
        if(visited[current]) return true;
        visited[current]=true;path[current]=true;
        for(int course:list[current]){
            if(!dfs(list,path,visited,course)) return false;
        }
        path[current]=false;
        return true;
    }
    public boolean canFinish(int N, int[][] prerequisites) {
        @SuppressWarnings("unchecked")
        List<Integer>[] list=new ArrayList[N];
        for(int idx=0;idx<N;idx++){
            list[idx]=new ArrayList<>();
        }
        for(int[] course:prerequisites){
            list[course[0]].add(course[1]);
        }
        boolean[] visited=new boolean[N];
        boolean[] path=new boolean[N];
        for(int idx=0;idx<N;idx++){
            if(!dfs(list,path,visited,idx)) return false;
        }
        return true;
    }
}
