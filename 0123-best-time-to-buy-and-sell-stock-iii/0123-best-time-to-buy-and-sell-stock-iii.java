class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==1){
            return 0;
        }


        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0];
        if(dp.length>=2){
            dp[1][1] = -prices[0] + prices[1]; 

        }
        if(dp.length>=3){
            dp[2][2] = -prices[0] + prices[1]- prices[2]; 
            
        }
        if(dp.length>=4){
            dp[3][3] = -prices[0] + prices[1]- prices[2]+prices[3]; 
        }
        

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] =  Math.max(dp[i-1][0], - prices[i]); //持有1
            if(i>1){
                dp[i][1] = Math.max(dp[i-1][1] , dp[i-1][0] + prices[i]);   //不持有但是已经持有1
            }
            if(i>2){
                dp[i][2] =  Math.max(dp[i-1][2], dp[i-1][1] - prices[i]);   //持有第二个
            }
            if(i>3){
                dp[i][3] = Math.max(dp[i-1][3] , dp[i-1][2] + prices[i]);    //不持有但是已经结束了（持有2个）
            }
            
        }
        int maxPro = 0;
        for (int i = 0; i < dp[0].length; i++) {
            if(dp[dp.length-1][i]>maxPro){
                maxPro = dp[dp.length-1][i];
            }
        } 
        return  maxPro;

    }
}