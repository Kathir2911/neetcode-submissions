class Solution {
    private static int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
    public int orangesRotting(int[][] grid) {
        Deque<int[]> queue=new ArrayDeque<>();
        int R=grid.length, C=grid[0].length;
        int fresh=0,count=0;       
        for(int row=0;row<R;row++){
            for(int col=0;col<C;col++){
                if(grid[row][col]==2){
                    queue.add(new int[]{row,col});
                }
                else if(grid[row][col]==1) fresh++;
            }
        }
        if(fresh==0) return 0;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int idx=0;idx<size;idx++){
                int[] temp=queue.poll();
                int row=temp[0], col=temp[1];
                for(int jdx=0;jdx<4;jdx++){
                    int adjR=row+dir[jdx][0];
                    int adjC=col+dir[jdx][1];
                    if(adjR<0 || adjC<0 || adjR>=R || adjC>=C ||grid[adjR][adjC]!=1) continue;
                    if(grid[adjR][adjC]==1) fresh--;
                    grid[adjR][adjC]=2;
                    queue.add(new int[]{adjR,adjC});
                }
            }
            count++;
            if(fresh==0) break;
        }
        return fresh!=0?-1:count;
    }
   
    
}
