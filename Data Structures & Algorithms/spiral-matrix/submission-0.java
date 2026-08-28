class Solution {
    private static List<Integer> list;
    private static void dfs(int row,int col,int r,int c,int dirR,int dirC,int[][] matrix){
        if(row==0 || col==0) return;
        for(int idx=0;idx<col;idx++){
            r+=dirR;
            c+=dirC;
            list.add(matrix[r][c]);
        }
        dfs(col,row-1,r,c,dirC,-dirR,matrix);
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        int R=matrix.length,C=matrix[0].length;
        list=new ArrayList<>();
        dfs(R,C,0,-1,0,1,matrix);
        return list;
    }
}
