class Solution {
    public int maxProfit(int[] prices) {
        //[1,2,3,0,2]
        // not buy for a long time; holding, cooldown, just sell; 
        int[][] dp = new int[prices.length][4];
        dp[0][0] = 0; 
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = 0;
        for (int i = 1; i < prices.length; i++) {

            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][3]); 

            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);

            dp[i][2] = dp[i-1][3];

            dp[i][3] = dp[i-1][1]+ prices[i];

        }
        int tepres = Math.max(dp[prices.length-1][0],dp[prices.length-1][1]);
        int tepres2 =  Math.max(tepres,dp[prices.length-1][2] );
        return Math.max(tepres2,dp[prices.length-1][3] );
    }
}