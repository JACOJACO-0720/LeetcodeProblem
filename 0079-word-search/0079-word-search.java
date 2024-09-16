class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        // 特殊情况处理
        if (word.length() == 0) return true;
        if (rows * cols < word.length()) return false;

        boolean[][] visited = new boolean[rows][cols];
        // 遍历每个起始点
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 如果找到匹配的首字母，开始DFS
                if (dfs(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, String word, int x, int y, int index, boolean[][] visited) {
        // 超出边界或已访问或字符不匹配，返回false
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length ||
            visited[x][y] || board[x][y] != word.charAt(index)) {
            return false;
        }

        // 全部字符匹配，返回true
        if (index == word.length() - 1) {
            return true;
        }

        visited[x][y] = true; // 标记为已访问

        // 递归搜索上下左右四个方向
        boolean res = dfs(board, word, x + 1, y, index + 1, visited) ||
                      dfs(board, word, x - 1, y, index + 1, visited) ||
                      dfs(board, word, x, y + 1, index + 1, visited) ||
                      dfs(board, word, x, y - 1, index + 1, visited);

        visited[x][y] = false; // 回溯，取消标记

        return res;
    }
}
