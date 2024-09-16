class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, String word, int x, int y, boolean[][] visited) {
        if ( outofbound(board, x, y)||visited[x][y] ) {
            return false;
        }
        if (word.length() == 1 && word.equals(String.valueOf(board[x][y]))) {
            return true;
        }
        if (word.length() == 1) {
            return false;
        }

        if (word.charAt(0) == board[x][y]) {
            visited[x][y] = true;
            boolean res = dfs(board, word.substring(1), x + 1, y, visited) ||
                    dfs(board, word.substring(1), x, y - 1, visited) ||
                    dfs(board, word.substring(1), x, y + 1, visited) ||
                    dfs(board, word.substring(1), x - 1, y, visited);
            if (res) {
                return true;
            } else {
                visited[x][y] = false;
                return false;
            }
        }else{
            return false;
        }


    }

    boolean outofbound(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return true;
        }
        return false;
    }
}