class Solution {
    public int orangesRotting(int[][] grid) {
        boolean[][] notTraverse = new boolean[grid.length][grid[0].length];
        int totalcount  = 0;
        int count = 0;
        int step = 0;
        ArrayDeque<int[]> ad = new ArrayDeque<>();
        for (int i = 0; i < notTraverse.length; i++) {
            for (int j = 0; j < notTraverse[0].length; j++) {
                if(grid[i][j]==1){
                    totalcount++;
                    notTraverse[i][j]=true;
                }else if(grid[i][j]==2){
                    totalcount++;
                    int[] temp = new int[2];
                    temp[0]=i;temp[1]=j;ad.add(temp);
                    count++;
                }
                    
            }
        }
        while(!ad.isEmpty()){
            step++;
            int size = ad.size();
            for (int i = 0; i < size; i++) {
                int[] temp = ad.poll();
                if(withinBound(temp[0]+1, temp[1], grid)&&notTraverse[temp[0]+1][temp[1]]){
                    notTraverse[temp[0]+1][temp[1]]= false;
                    int[] newtemp = new int[2];
                    newtemp[0] = temp[0]+1;
                    newtemp[1] = temp[1];
                    ad.add(newtemp);
                    count++;
                }
                if(withinBound(temp[0]-1, temp[1], grid)&&notTraverse[temp[0]-1][temp[1]]){
                    notTraverse[temp[0]-1][temp[1]]= false;
                    int[] newtemp = new int[2];
                    newtemp[0] = temp[0]-1;
                    newtemp[1] = temp[1];
                    ad.add(newtemp);
                    count++;
                }
                if(withinBound(temp[0], temp[1]+1, grid)&&notTraverse[temp[0]][temp[1]+1]){
                    notTraverse[temp[0]][temp[1]+1]= false;
                    int[] newtemp = new int[2];
                    newtemp[0] = temp[0];
                    newtemp[1] = temp[1]+1;
                    ad.add(newtemp);
                    count++;
                }if(withinBound(temp[0], temp[1]-1, grid)&&notTraverse[temp[0]][temp[1]-1]){
                    notTraverse[temp[0]][temp[1]-1]= false;
                    int[] newtemp = new int[2];
                    newtemp[0] = temp[0];
                    newtemp[1] = temp[1]-1;
                    ad.add(newtemp);
                    count++;
                }
            }

        }
                    if(count!=totalcount){
                return -1;
            }else{
                return step-1<0?0:step-1;
            }

    }
    boolean withinBound(int x, int y, int[][] grid){
        if(x>=0&&x<grid.length&&y>=0&&y<grid[0].length){
            return true;
        }else{
            return false;
        }
    }
}