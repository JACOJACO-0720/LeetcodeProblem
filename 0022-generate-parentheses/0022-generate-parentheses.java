class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String current, int open, int close, int max) {
        // If the current string is a valid combination, add it to the result
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        // If we can add an open parenthesis, do so
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }

        // If we can add a close parenthesis, do so
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }
}