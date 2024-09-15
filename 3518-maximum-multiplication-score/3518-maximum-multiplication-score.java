class Solution {
    public long maxScore(int[] a, int[] b) {
        //0 1 2 3 4
        long[][] dp = new long[b.length][5];
        dp[0][0]=0;
        dp[0][1]=a[0]*b[0];
        dp[1][2]=dp[0][1] + (long)a[1]*b[1];
        dp[2][3]=dp[1][2] + (long)a[2]*b[2];
        dp[3][4]=dp[2][3] + (long)a[3]*b[3];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < Math.min(i+1,5); j++) {
                dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1] + (long)a[j-1]*b[i] );
            }
        }
        return dp[dp.length-1][4];
    }
    public static void main(String[] args) {
        int[] input1 = {-1,4,5,-2};
        int[] input2 = {-5,-1,-3,-2,-4};
        Solution solution = new Solution();
        System.out.println(solution.maxScore(input1, input2));
    }
}