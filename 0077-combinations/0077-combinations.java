class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> currentCombination = new ArrayList<>();
        backtrack(n, k, 1, 0, result, currentCombination);
        return result;
    }

    void backtrack(int n, int k, int start, int selectedCount, List<List<Integer>> result, ArrayList<Integer> currentCombination) {
        if (selectedCount == k) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }
        for (int i = start; i <= n; i++) {
            currentCombination.add(i);
            backtrack(n, k, i + 1, selectedCount + 1, result, currentCombination);
            currentCombination.remove(currentCombination.size() - 1); 
        }
    }
}
