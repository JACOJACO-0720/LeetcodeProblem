class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);  // 排序数组，方便处理重复
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(candidates, cur, res, target, 0);  // 从索引 0 开始递归
        return res;
    }

    void dfs(int[] candidates, List<Integer> cur, List<List<Integer>> res, int target, int idx) {
        if (target == 0) {  // 如果目标为 0，找到合法组合
            res.add(new ArrayList<>(cur));  // 添加当前组合到结果集
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            // 跳过相邻重复的元素，防止重复组合
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (candidates[i] > target) {  // 如果当前元素大于目标值，直接剪枝
                break;
            }

            cur.add(candidates[i]);  // 选择当前元素
            dfs(candidates, cur, res, target - candidates[i], i + 1);  // 递归调用，i + 1 是为了不重复使用同一个元素
            cur.remove(cur.size() - 1);  // 回溯，移除最后添加的元素
        }
    }
}
