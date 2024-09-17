import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TreeNode root = buildTree(words);
        List<String> res = new ArrayList<>();
        int m = board.length;
        int n = board[0].length;
        boolean[][] isVisited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, isVisited, res);
            }
        }
        return res;
    }

    void dfs(char[][] board, int x, int y, TreeNode root, boolean[][] isVisited, List<String> res) {
        if (outOfBound(board, x, y) || isVisited[x][y]) {
            return;
        }

        char curChar = board[x][y];
        root = root.array[curChar - 'a'];
        if (root == null) {
            return;
        }

        if (root.word != null) {
            res.add(root.word);
            root.word = null;  // 避免重复添加
        }

        isVisited[x][y] = true;

        dfs(board, x + 1, y, root, isVisited, res);
        dfs(board, x - 1, y, root, isVisited, res);
        dfs(board, x, y + 1, root, isVisited, res);
        dfs(board, x, y - 1, root, isVisited, res);

        isVisited[x][y] = false;  // 回溯
    }

    boolean outOfBound(char[][] board, int x, int y) {
        return x < 0 || x >= board.length || y < 0 || y >= board[0].length;
    }

    TreeNode buildTree(String[] words) {
        TreeNode root = new TreeNode();

        for (String word : words) {
            TreeNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.array[c - 'a'] == null) {
                    cur.array[c - 'a'] = new TreeNode();
                }
                cur = cur.array[c - 'a'];
            }
            cur.word = word;  // 在终止节点存储完整单词
        }

        return root;
    }

    class TreeNode {
        String word = null;
        TreeNode[] array = new TreeNode[26];
    }
}
