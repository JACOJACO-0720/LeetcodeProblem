import java.util.HashMap;

class Solution {
    public int minTotalDistance(int[][] grid) {
        HashMap<Integer, Integer> column = new HashMap<>();
        HashMap<Integer, Integer> row = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1){
                    int num = row.getOrDefault(i, 0)+1;
                    row.put(i, num);
                    int num1 = column.getOrDefault(j, 0)+1;
                    column.put(j, num1);
                }
            }
        }
        int[][] rowprefix = new int[grid.length][2]; //0 means num, 1 means distance
        rowprefix[0][0] = row.getOrDefault(0,0);
        rowprefix[0][1] = 0;
        for (int i = 1; i < rowprefix.length; i++) {
            rowprefix[i][0] = rowprefix[i-1][0] + row.getOrDefault(i,0) ;
            rowprefix[i][1] = rowprefix[i-1][1] + rowprefix[i-1][0];
        }
        
        int[][] rowsuffix = new int[grid.length][2];
        rowsuffix[grid.length - 1][0] = row.getOrDefault(grid.length - 1,0);
        rowsuffix[grid.length - 1][1] = 0;
        for (int i = grid.length - 2; i >=0 ; i--) {
            rowsuffix[i][0] = rowsuffix[i + 1][0] + row.getOrDefault(i,0);
            rowsuffix[i][1] = rowsuffix[i + 1][1] + rowsuffix[i + 1][0];
        }

        int[][] columnprefix = new int[grid[0].length][2]; //0 means num, 1 means distance
        columnprefix[0][0] = column.getOrDefault(0,0);
        columnprefix[0][1] = 0;
        for (int i = 1; i < columnprefix.length; i++) {
            columnprefix[i][0] = columnprefix[i-1][0] + column.getOrDefault(i,0);
            columnprefix[i][1] = columnprefix[i-1][1] + columnprefix[i-1][0];
        }

        int[][] columnsuffix = new int[grid[0].length][2];
        columnsuffix[grid[0].length - 1][0] = column.getOrDefault(grid[0].length - 1,0);
        columnsuffix[grid[0].length - 1][1] = 0;
        for (int i = grid[0].length - 2; i >=0 ; i--) {
            columnsuffix[i][0] = columnsuffix[i + 1][0] + column.getOrDefault(i,0);
            columnsuffix[i][1] = columnsuffix[i + 1][1] + columnsuffix[i + 1][0];
        }


        int min = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                min = Math.min(min, rowprefix[i][1] + rowsuffix[i][1] + columnprefix[j][1] + columnsuffix[j][1]);
            }
        }
        return min;

    }
}