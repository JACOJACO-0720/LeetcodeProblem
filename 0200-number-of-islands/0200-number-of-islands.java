class Solution {

    public int numIslands(char[][] grid) {
        int sum = 0;
        int width = grid.length;
        int length = grid[0].length;
        for(int i = 0 ;i < width;i++){
            for(int j =0; j<length; j++){
                if(grid[i][j] == '0'){
                  continue;
                }else{
                sum++;
                DFS(grid, i, j);
                }
            }
        }
        return sum;
    }
    

    void DFS(char[][] grid, int currentX, int currentY){
        if(currentX<0||currentX>grid.length-1||currentY<0||currentY>grid[0].length-1||grid[currentX][currentY]=='0'){
            return;
        }
        grid[currentX][currentY]='0';
        DFS(grid, currentX+1, currentY);
        DFS(grid, currentX, currentY+1);
        DFS(grid, currentX-1, currentY);
        DFS(grid, currentX, currentY-1);
    }


}