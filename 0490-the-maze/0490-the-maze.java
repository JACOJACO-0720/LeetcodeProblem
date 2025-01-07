class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][][] visited = new boolean[maze.length][maze[0].length][4];
        // for (int i = 0; i < 4; i++) {
        //     visited[start[0]][start[1]][i] = true; 
        // }
        return dfs(visited, start[0],  start[1], 0, maze,destination)||
        dfs(visited, start[0],  start[1], 1, maze,destination)||
        dfs(visited, start[0],  start[1], 2, maze,destination)||
        dfs(visited, start[0],  start[1], 3, maze,destination);


    }
    boolean dfs(boolean[][][] visited, int x, int y, int direction, int[][] maze,int[] destination){
        if(x==destination[0]&&y==destination[1]){
            return true;
        }
        if(visited[x][y][direction]){
            return false;
        }
        visited[x][y][direction] = true;
        int curx = x; int cury = y;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}}; 
        int[] curdir = dirs[direction];
        while(!outofborder(maze, curx+curdir[0], cury+curdir[1]) && maze[curx+curdir[0]][cury+curdir[1]]!=1){
            curx = curx + curdir[0]; cury=cury+curdir[1];
        }
        if(curx==x&&cury==y){
            return false;
        }
        boolean found = false;
        for(int i =0;i< dirs.length;i++){
            found = found || dfs(visited, curx,  cury, i, maze,destination);
        }
        return found;
    }

    boolean outofborder(int[][] maze, int x, int y){
        return x<0||y<0||x>=maze.length||y>=maze[0].length;
    }
    

}