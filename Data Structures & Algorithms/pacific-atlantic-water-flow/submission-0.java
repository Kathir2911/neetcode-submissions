class Solution {
    private static List<List<Integer>> result;

    private static int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};

    private static void dfs(int R,int C,int row,int col,int[][] heights,boolean[][] visited){
        visited[row][col]=true;
        for(int idx=0;idx<4;idx++){
            int adjR=row+dir[idx][0];
            int adjC=col+dir[idx][1];
            if(adjR<0 || adjC<0 || adjR>=R || adjC>=C || visited[adjR][adjC] || heights[adjR][adjC]<heights[row][col]) continue;
            dfs(R,C,adjR,adjC,heights,visited);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        result=new ArrayList<>();
        int R=heights.length;
        int C=heights[0].length;
        boolean[][] pacific=new boolean[R][C];
        boolean[][] atlantic=new boolean[R][C];
        for(int row=0;row<R;row++){
            dfs(R,C,row,0,heights,pacific);
        }
        for(int col=0;col<C;col++){
            dfs(R,C,0,col,heights,pacific);
        }
        
        for(int row=0;row<R;row++){
            dfs(R,C,row,C-1,heights,atlantic);
        }
        for(int col=0;col<C;col++){
            dfs(R,C,R-1,col,heights,atlantic);
        }

        for(int row=0;row<R;row++){
            for(int col=0;col<C;col++){
                if(atlantic[row][col] && pacific[row][col]){
                    result.add(Arrays.asList(row,col));
                }
            }
        }
        return result;
    }
}
