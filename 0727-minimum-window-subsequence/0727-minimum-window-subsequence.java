class Solution {
    public String minWindow(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();

        int[][] dp = new int[n2 + 1][n1 + 1];
        int len = n1 + 1, endOfWindow = -1;


        for (int i = 1; i <= n2; i++) {
            for (int j = 1; j <= n1; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    // 检查前一个位置的值
                    if (i != 1 && dp[i - 1][j - 1] == 0) {
                        dp[i][j] = 0; // 如果 i 不等于 1 且前一个位置的值小于等于 0，则当前值为 0
                    } else {
                        dp[i][j] = 1 + dp[i - 1][j - 1]; // 否则，当前值为前一个位置的值加 1
                    }

                    // 如果已经匹配到 t 的最后一个字符
                    if (i == n2 && dp[i][j] != 0 && len > dp[i][j]) {
                        len = dp[i][j]; // 更新最小窗口的长度
                        endOfWindow = j - 1; // 记录当前最小窗口的结束位置
                    }
                } else {
                    // 当 t 的字符与 s 的字符不同时
                    if (dp[i][j - 1] > 0) {
                        dp[i][j] = 1 + dp[i][j - 1]; // 如果左侧位置的值大于 0，则当前值为左侧位置的值加 1
                    } else {
                        dp[i][j] = 0; // 否则，当前值为 0
                    }
                }
            }
        }

        // 如果没有找到满足条件的窗口，则返回空字符串，否则返回最小窗口子字符串
        return (len == n1 + 1) ? "" : s.substring(endOfWindow - len + 1, endOfWindow + 1);
    }
}
