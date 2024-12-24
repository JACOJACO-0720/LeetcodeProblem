class Solution {
    public List<List<Integer>> combine(int n, int k) {
        // 用于存储最终结果的列表
        List<List<Integer>> result = new ArrayList<>();
        // 当前构建的组合
        ArrayList<Integer> currentCombination = new ArrayList<>();
        // 开始递归构建组合
        backtrack(n, k, 1, 0, result, currentCombination);
        return result;
    }

    void backtrack(int n, int k, int start, int selectedCount, List<List<Integer>> result, ArrayList<Integer> currentCombination) {
        // 如果已选数量达到目标 k，则将当前组合保存到结果中
        if (selectedCount == k) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        // 从当前数字开始，尝试添加每个数字到组合中
        for (int i = start; i <= n; i++) {
            currentCombination.add(i); // 选择当前数字
            backtrack(n, k, i + 1, selectedCount + 1, result, currentCombination); // 递归选择下一个数字
            currentCombination.remove(currentCombination.size() - 1); // 撤销选择，回溯
        }
    }
}
