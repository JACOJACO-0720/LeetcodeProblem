import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                int temp = coins[j];
                if(i-temp>=0 && dp[i-temp]!=Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i-temp]+1, dp[i]);
                }
            }
        }
       
        return dp[dp.length-1]==Integer.MAX_VALUE? -1: dp[dp.length-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

    }
}