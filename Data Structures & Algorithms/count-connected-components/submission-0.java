class Solution {
    private static boolean[] visited;
    private static void dfs(List<Integer>[] adj,int node){
        for(int neighbour:adj[node]){
            if(visited[neighbour]) continue;
            visited[neighbour]=true;
            dfs(adj,neighbour);
        }
    }
    public int countComponents(int n, int[][] edges) {
        @SuppressWarnings("unchecked")
        List<Integer>[] adj=new ArrayList[n];
        for(int idx=0;idx<n;idx++) adj[idx]=new ArrayList<>();
        for(int[] edge:edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        visited=new boolean[n];
        int count=0;
        for(int idx=0;idx<n;idx++){
            if(visited[idx]) continue;
            visited[idx]=true;
            dfs(adj,idx);
            count++;
        }
        return count;
    }
}
/**0 1
1 0,2
2 1
3 4
4 3**/