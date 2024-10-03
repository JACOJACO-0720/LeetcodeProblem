class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];  // dp[i] 表示从第i个字符到字符串末尾的最小切割数
        boolean[][] isPalindrome = new boolean[n][n];  // 记录每个子串是否是回文

        // 预处理所有子串是否是回文
        for (int end = 0; end < n; end++) {
            for (int start = 0; start <= end; start++) {
                if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || isPalindrome[start + 1][end - 1])) {
                    isPalindrome[start][end] = true;
                }
            }
        }

        return helperFunction(s, 0, dp, isPalindrome) - 1;  // 减1是因为多加了1次切割
    }

    int helperFunction(String s, int start, int[] dp, boolean[][] isPalindrome) {
        if (start == s.length()) {
            return 0;  // 已经到了字符串末尾，0次切割
        } else if (dp[start] != 0) {
            return dp[start];  // 返回已经计算过的结果
        }

        int min = Integer.MAX_VALUE;
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome[start][i]) {  // 如果s[start...i]是回文
                min = Math.min(min, helperFunction(s, i + 1, dp, isPalindrome) + 1);  // 递归求解剩下部分的最小切割数
            }
        }

        dp[start] = min;  // 记忆化存储结果
        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minCut("aab"));  // 输出 1
    }
}
