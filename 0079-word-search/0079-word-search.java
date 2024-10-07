class Solution {
    public boolean exist(char[][] board, String word) {

        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                boolean res = dfs(visited, i, j, board,word,0);
                if(res){
                    return true;
                }
            }
        }
        return false;
    }
    
    boolean dfs(boolean[][] visited, int i ,int j, char[][] board,String word, int cur){
        if(outofbound(i,j, board) ||visited[i][j] ||  word.charAt(cur)!=board[i][j]){
            return false;
        }
        if(cur==word.length()-1){
            return true;
        }else{
            visited[i][j] = true;
            boolean res =  dfs(visited, i+1, j, board,word,cur+1)
                    ||dfs(visited, i-1, j, board,word,cur+1)
                    ||dfs(visited, i, j+1, board,word,cur+1)
                    ||dfs(visited, i, j-1, board,word,cur+1);
            visited[i][j] = false;
            return res;
        }
    }
    boolean outofbound(int i ,int j, char[][] board){
        return i<0||j<0||i>=board.length||j>=board[0].length;
    }
}