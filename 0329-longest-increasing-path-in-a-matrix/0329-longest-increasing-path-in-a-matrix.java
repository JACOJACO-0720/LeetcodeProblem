class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                res = Math.max(res, dfs(matrix, i ,j, dp));
            }
        }
        return res;
    }
    int dfs(int[][] matrix, int i , int j , int[][] dp){
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int temp = 1;
        if(!outofbound(matrix, i+1,j) && matrix[i+1][j]>matrix[i][j]){
            temp = Math.max(temp, 1 + dfs(matrix, i+1,j,dp) );
        }
        if(!outofbound(matrix, i-1,j) && matrix[i-1][j]>matrix[i][j]){
            temp = Math.max(temp, 1 + dfs(matrix, i-1,j,dp) );
        }
        if(!outofbound(matrix, i,j+1) && matrix[i][j+1]>matrix[i][j]){
            temp = Math.max(temp, 1 + dfs(matrix, i,j+1,dp) );
        }
        if(!outofbound(matrix, i,j-1) && matrix[i][j-1]>matrix[i][j]){
            temp = Math.max(temp, 1 + dfs(matrix, i,j-1,dp) );
        }
        dp[i][j] = temp;
        return dp[i][j];
    }
    boolean outofbound(int[][] matrix, int i , int j){
        return i<0||i>=matrix.length||j<0||j>=matrix[0].length;
    }

}