class Solution {
    public int minCut(String s) {
        int n = s.length();
        // dp[i] 表示从第i个字符到字符串末尾需要的最小切割数
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            dp[i] = i;  // 最坏的情况下，每个字符都要切割
        }

        // isPalindrome[i][j] 表示 s[i...j] 是否为回文
        boolean[][] isPalindrome = new boolean[n][n];
        
        // 预处理所有子串是否是回文
        for (int end = 0; end < n; end++) {
            for (int start = 0; start <= end; start++) {
                if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || isPalindrome[start + 1][end - 1])) {
                    isPalindrome[start][end] = true;
                }
            }
        }

        // 计算最小切割数
        for (int i = 1; i < n; i++) {
            if (isPalindrome[0][i]) {
                dp[i] = 0;  // 如果 s[0...i] 是回文，不需要切割
            } else {
                // 尝试所有可能的切割点
                for (int j = 0; j < i; j++) {
                    if (isPalindrome[j + 1][i]) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }
        
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minCut("aab"));  // 输出 1
    }
}
