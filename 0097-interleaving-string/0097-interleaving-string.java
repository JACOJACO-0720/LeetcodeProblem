class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        // dp 表示是否可以通过 s1 的前 i 个字符和 s2 的前 j 个字符拼接得到 s3 的前 i+j 个字符
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        // 初始化起点
        dp[0][0] = true;

        // 填充 dp 表格
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i > 0) {
                    dp[i][j] = dp[i][j] || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
