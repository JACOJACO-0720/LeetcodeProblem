class Solution {
    public int closedIsland(int[][] grid) {
        int res  = 0;
        int c = 1;
        for (int i = 1; i < grid.length-1; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                if(grid[i][j]==0){
                    c++;
                    if(dfs(grid,i,j, c)){
                        res++;
                    }
                }

            }
        }
        return res;
    }
    boolean dfs(int[][] grid, int x, int y,int c){
        if(grid[x][y]==1||grid[x][y]==c){
            return true;
        }
        if(isEdge(grid,x,y)){

            return false;
        }
        grid[x][y]=c;
        return dfs(grid,x+1,y,c) && dfs(grid,x-1,y,c) && dfs(grid,x,y-1,c) && dfs(grid,x,y+1,c);
        
        
        
    }

    boolean isEdge(int[][] grid, int x, int y){
        return x==0||y==0||x==grid.length-1||y==grid[0].length-1;
    }
}