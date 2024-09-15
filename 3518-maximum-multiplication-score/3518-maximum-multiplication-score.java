import java.util.Arrays;

class Solution {
    public long maxScore(int[] a, int[] b) {
        //0 1 2 3 4
        long[][] dp = new long[b.length][5];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], (long)-1e11);
        }

        for (int i = 0; i < b.length; i++) {
            dp[i][0]=0;
        }
        dp[0][1]=(long)a[0]*b[0];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < 5; j++) {
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


//    public long maxScore(int[] a, int[] b) {
//        long[] dp = new long[4];
//        Arrays.fill(dp, (long)-1e11);
//        for (int bi : b)
//            for (int i = 3; i >= 0; i--)
//                dp[i] = Math.max(dp[i], (i > 0 ? dp[i - 1] : 0) + 1L * a[i] * bi);
//        return dp[3];
//    }