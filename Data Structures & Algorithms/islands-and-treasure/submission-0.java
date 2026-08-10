class Solution {
    
    private static int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};

    private static int INF=Integer.MAX_VALUE-1;
    public void islandsAndTreasure(int[][] grid) {
        int R=grid.length;
        int C=grid[0].length;
        Deque<int[]> queue=new ArrayDeque<>();
        boolean[][] visited=new boolean[R][C];
        for(int row=0;row<R;row++){
            for(int col=0;col<C;col++){
                if(grid[row][col]==0){
                    queue.add(new int[]{row,col});
                    visited[row][col]=true;
                }
            }
        }
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int idx=0;idx<size;idx++){
                int[] temp=queue.poll();
                int row=temp[0], col=temp[1];
                for(int jdx=0;jdx<4;jdx++){
                    int adjR=row+dir[jdx][0];
                    int adjC=col+dir[jdx][1];
                    if(adjR<0 || adjC<0 || adjR>=R || adjC>=C || visited[adjR][adjC] || grid[adjR][adjC]==-1) continue;
                    grid[adjR][adjC]=grid[row][col]+1;
                    queue.add(new int[]{adjR,adjC});
                    visited[adjR][adjC]=true;
                }
            }
        }
    }
}
