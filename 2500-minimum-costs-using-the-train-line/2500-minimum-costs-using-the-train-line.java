class Solution {
    public long[] minimumCosts(int[] regular, int[] express, int expressCost) {
        long[][] dp = new long[regular.length+1][2];
        long[] res = new long[regular.length];
        dp[0][0] =  0;
        dp[0][1] =  expressCost;

        for (int i = 0; i < regular.length; i++) {
            dp[i+1][0] = Math.min(dp[i][0] + regular[i], dp[i][1]+express[i]);
            dp[i+1][1] = Math.min(dp[i][1] + express[i], dp[i][0]+expressCost + regular[i]);
            res[i] = Math.min(dp[i+1][0],dp[i+1][1]);
        }

        return res;
    }
}