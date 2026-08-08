class Solution {
    private static boolean[] visited;
    private static boolean dfs(List<Integer>[] list,int node, int parent){
        visited[node]=true;
        for(int neighbour:list[node]){
            if(neighbour==parent) continue;
            if(visited[neighbour]) return false;
            if(!dfs(list,neighbour,node)) return false;
        }
        return true;
    }
    public boolean validTree(int n, int[][] edges) {
        @SuppressWarnings("unchecked")
        List<Integer>[] list=new ArrayList[n];
        for(int idx=0;idx<n;idx++){
            list[idx]=new ArrayList<>();
        }
        for(int[] edge:edges){
            int u=edge[0], v=edge[1];
            list[u].add(v);
            list[v].add(u);
        }
        visited=new boolean[n];
        
        if(!dfs(list,0,-1)) return false;
        for(boolean value:visited) if(!value) return false;
        return true;
    }
}
