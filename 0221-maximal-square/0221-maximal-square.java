class Solution {
    int max = 0;
    public int maximalSquare(char[][] matrix) {
        int[][] dp  = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, dfs(i , j, dp, matrix));
            }
        } 
        return max*max;
    }
    int dfs(int i , int j ,int[][] dp, char[][] matrix){
        if(outofbound(matrix, i , j) || matrix[i][j]=='0'){
            return 0;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int max = 0;
        max = Math.min(dfs(i+1 , j, dp, matrix)+1,dfs(i, j+1, dp, matrix)+1);
        max = Math.min(max, dfs(i+1 , j+1, dp, matrix)+1);
        dp[i][j] = max;
        return dp[i][j]; 
    

    }

    boolean outofbound(char[][] matrix, int x, int y){
        return x<0 || x>= matrix.length|| y<0||y>=matrix[0].length;

    }

}