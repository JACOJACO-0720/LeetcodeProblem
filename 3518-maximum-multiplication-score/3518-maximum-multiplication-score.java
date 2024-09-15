class Solution {
    public long maxScore(int[] a, int[] b) {
        long[] dp = new long[4];
        Arrays.fill(dp, (long)-1e11);
        for (int bi : b)
            for (int i = 3; i >= 0; i--)
                dp[i] = Math.max(dp[i], (i > 0 ? dp[i - 1] : 0) + 1L * a[i] * bi);
        return dp[3];
    }
}