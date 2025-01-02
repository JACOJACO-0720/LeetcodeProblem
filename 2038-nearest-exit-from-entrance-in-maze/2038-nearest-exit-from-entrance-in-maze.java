import java.util.ArrayDeque;

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int res = 0;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean isfirst = true;
        queue.add(entrance);
       
        while(!queue.isEmpty()){
           
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] tmp = queue.poll();
                if(outofbounds(maze ,tmp[0],tmp[1])||maze[tmp[0]][tmp[1]]=='+' ){
                    continue;
                }else if(isboarder(maze, tmp[0],tmp[1]) && tmp[0]==entrance[0] && tmp[1]==entrance[1]){
                    maze[tmp[0]][tmp[1]] = '+';
                    queue.add(new int[]{tmp[0]+1, tmp[1]});
                    queue.add(new int[]{tmp[0]-1, tmp[1]});
                    queue.add(new int[]{tmp[0], tmp[1]+1});
                    queue.add(new int[]{tmp[0], tmp[1]-1});
                }
                else if(isboarder(maze, tmp[0],tmp[1])){
                    return res;
                }
                else{
                    maze[tmp[0]][tmp[1]] = '+';
                    queue.add(new int[]{tmp[0]+1, tmp[1]});
                    queue.add(new int[]{tmp[0]-1, tmp[1]});
                    queue.add(new int[]{tmp[0], tmp[1]+1});
                    queue.add(new int[]{tmp[0], tmp[1]-1});
                }
            }
            res++;
        }
        return -1;
    }


    boolean isboarder (char[][] maze, int x, int y){
        return x==0 || y ==0 || x==maze.length-1 || y==maze[0].length-1;
    }


    boolean outofbounds (char[][] maze, int x, int y){
        return x<0||y<0||x>=maze.length||y>=maze[0].length;
    }


}