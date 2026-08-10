class Solution {
    private static int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};

    private static int dfs(int R,int C,int row,int col,char[][] grid){
        int count=0;
        for(int idx=0;idx<4;idx++){
            int adjR=row+dir[idx][0];
            int adjC=col+dir[idx][1];
            if(adjR<0 || adjC<0 || adjR>=R || adjC>=C || grid[adjR][adjC]=='0') continue;
            grid[adjR][adjC]='0';
            count+=dfs(R,C,adjR,adjC,grid);
        }
        return count;
    }

    public int numIslands(char[][] grid) {
        int R=grid.length;
        int C=grid[0].length;
        int count=0;
        for(int row=0;row<R;row++){
            for(int col=0;col<C;col++){
                if(grid[row][col]=='1'){
                    count+=dfs(R,C,row,col,grid)+1;
                }
            }
        }    
        return count;
    }
}
