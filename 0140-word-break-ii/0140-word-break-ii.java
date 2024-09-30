import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        // 构建 Trie 树
        TreeNode root = new TreeNode();
        for (String word : wordDict) {
            TreeNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (cur.list[index] == null) {
                    cur.list[index] = new TreeNode();
                }
                cur = cur.list[index];
            }
            cur.isend = true;  // 标记单词结束
        }

        // 初始化 dp 数组
        List<ArrayList<Integer>> dp = new ArrayList<>(s.length() + 1);
        for (int i = 0; i <= s.length(); i++) {
            dp.add(new ArrayList<>());
        }

        List<String> res = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        
        // 调用 dfs 进行回溯搜索
        dfs(s, dp, res, 0, temp, root);
        
        return res;
    }

    // 深度优先搜索函数
    void dfs(String s, List<ArrayList<Integer>> dp, List<String> res, int cur, ArrayList<String> temp, TreeNode root) {
        if (cur == s.length()) {
            StringBuilder sb = new StringBuilder();
            for (String t : temp) {
                sb.append(t).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1); // 移除最后一个空格
            res.add(sb.toString());
            return;
        }

        if (!dp.get(cur).isEmpty()) {
            List<Integer> tmplst = dp.get(cur);
            for (int next : tmplst) {
                temp.add(s.substring(cur, next + 1));
                dfs(s, dp, res, next + 1, temp, root);
                temp.remove(temp.size() - 1);
            }
            return;
        }

        int tempcur = cur;
        TreeNode curNode = root;
        ArrayList<Integer> tempdp = new ArrayList<>();
        
        while (tempcur < s.length()) {
            int index = s.charAt(tempcur) - 'a';
            if (curNode.list[index] == null) {
                break;  // 不能继续匹配
            }
            curNode = curNode.list[index];
            if (curNode.isend) {
                tempdp.add(tempcur);  // 记录可分割点
                temp.add(s.substring(cur, tempcur + 1));
                dfs(s, dp, res, tempcur + 1, temp, root);
                temp.remove(temp.size() - 1);  // 回溯
            }
            tempcur++;
        }

        dp.set(cur, tempdp);  // 缓存当前状态的可分割点
    }

    // Trie 树节点类
    class TreeNode {
        TreeNode[] list = new TreeNode[26];  // 每个节点代表一个字母
        boolean isend = false;               // 标记是否是一个单词的结束
    }
}
