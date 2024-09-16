class Solution {
    public int[][] generateMatrix(int n) {
        int count = 0;
        int status = 0;
        boolean[][] visited = new boolean[n][n];
        int[][] res = new int[n][n];
        int x= 0;int y =0;
        while(count != n*n ){
            res[x][y]=count+1;
             visited[x][y] = true;
            switch (status){
                case 0 :{
                   if(!outofbound(x, y+1, n)||visited[x][y+1]){
                        x++;
                        status=1;
                   }else{
                    y++;
                   }
                   break;
                }
                case 1:{
                    if(!outofbound(x+1, y, n)||visited[x+1][y]){
                        y--;
                        status=2;
                   }else{
                    x++;
                   }
                   break;
                }
                case 2:{
                    if(!outofbound(x, y-1, n)||visited[x][y-1]){
                        x--;
                          status=3;
                   }else{
                    y--;
                   }
                   break;
                }
                default: {
                    if(!outofbound(x-1, y, n)||visited[x-1][y]){
                        y++;
                        status=0;
                   }else{
                    x--;

                   }
                }
            }
           
            count++;
        }
return res;
    }
            boolean outofbound(int x, int y ,int n){
            return x>=0&&x<n &&y>=0&&y<n;
        }
}