class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int res =Integer.MAX_VALUE;
        boolean[][][] visited = new boolean[maze.length][maze[0].length][4]; 
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1,n2)-> Integer.compare(n1[4], n2[4]));
        // for(int[] i: new int[][]{{0,1},{0,-1},{1,0},{-1,0}}){
        //     if
        // }
        for(int[] i: new int[][]{{0,1},{0,-1},{1,0},{-1,0}}){
            if(!outofboarder(maze, start[0] + i[0], start[1] + i[1]) && maze[start[0] + i[0]][start[1] + i[1]]!=1){
                int[] tmp = {start[0], start[1], i[0],i[1] ,0};
                pq.add(tmp);
            }
        }

        while(!pq.isEmpty()){
            int[] tmp = pq.poll();
            int direction = turnintegerindex(tmp[2], tmp[3]);
            if(visited[tmp[0]][tmp[1]][direction]){
                continue;
            }else{
                visited[tmp[0]][tmp[1]][direction] = true;
                int curx = tmp[0];
                int cury = tmp[1];
                int distance = tmp[4];
                while(!outofboarder(maze, curx+tmp[2], cury+tmp[3])&&maze[curx+tmp[2]][cury+tmp[3]]!=1){
                    curx =  curx+tmp[2];
                    cury =  cury+tmp[3];
                    distance++;
                }
                if(destination[0]==curx&&destination[1]==cury){
                        res = Math.min(res,distance);
                }
                for(int[] i: new int[][]{{0,1},{0,-1},{1,0},{-1,0}}){
                    if(!outofboarder(maze, curx+i[0], cury+i[1]) && maze[curx + i[0]][cury + i[1]]!=1){
                        int[] t = {curx,cury, i[0],i[1] ,distance};
                        pq.add(t);
                    }
                }
            }
        }
        return res==Integer.MAX_VALUE? -1:res;
    }
    int turnintegerindex(int x, int y){
        if(x==0&&y==1){
            return 0;
        }
        if(x==0&&y==-1){
            return 1;
        }
        if(x==1&&y==0){
            return 2;
        }
        if(x==-1&&y==0){
            return 3;
        }
        return -1;
    }
    boolean outofboarder(int[][] maze, int x, int y){
        return x<0 || y <0 ||x>maze.length-1 || y > maze[0].length-1;
    }
}