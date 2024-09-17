import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        HashSet<String> hs = new HashSet<>();
        TreeNode root = buildTree(words);
        List<String> res = new ArrayList<>();
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(res, root, board, isVisited, "", i, j, hs);
            }
        }
        return res;
    }

    void dfs(List<String> res, TreeNode root, char[][] board, boolean[][] isVisited, String str, int x, int y, HashSet<String> hs) {
        if (root == null) {
            return;
        }

        if (root.hasValue) {
            if (!hs.contains(str)) {
                res.add(str);
                hs.add(str);
            }
        }

        if (outOfBound(board, x, y) || isVisited[x][y]) {
            return;
        }

        char cur = board[x][y];
        root = root.array[cur - 'a'];
        if (root == null) {
            return;
        }

        String newStr = str + cur;
        isVisited[x][y] = true;
        
        // Explore all 4 directions
        dfs(res, root, board, isVisited, newStr, x + 1, y, hs);
        dfs(res, root, board, isVisited, newStr, x, y + 1, hs);
        dfs(res, root, board, isVisited, newStr, x - 1, y, hs);
        dfs(res, root, board, isVisited, newStr, x, y - 1, hs);

        // Backtrack
        isVisited[x][y] = false;
    }

    boolean outOfBound(char[][] board, int x, int y) {
        return x < 0 || x >= board.length || y < 0 || y >= board[0].length;
    }

    TreeNode buildTree(String[] words) {
        TreeNode root = new TreeNode();
        
        for (String word : words) {
            TreeNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char temp = word.charAt(i);
                if (cur.array[temp - 'a'] == null) {
                    cur.array[temp - 'a'] = new TreeNode();
                }
                cur = cur.array[temp - 'a'];
            }
            cur.hasValue = true;  // Mark the end of a word
        }
        
        return root;
    }

    class TreeNode {
        boolean hasValue;
        TreeNode[] array = new TreeNode[26];  // 26 letters for 'a' to 'z'
    }
}
