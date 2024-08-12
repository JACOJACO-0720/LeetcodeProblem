class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }
        int s1l = s1.length();
        int s2l = s2.length();
        int[][] dp = new int[s1l+1][s2l+1];
        //init
        dp[0][0] = 0;
        int i = 0;
        for (i=0; i < s1l; i++) {
            if(s1.charAt(i) == s3.charAt(i)){
                dp[i+1][0] = dp[i][0]+1;
            }else{
                break;
            }
        }
        while(i < s1l){
            dp[i+1][0] = dp[i][0];
            i++;
        }

        for (i = 0; i < s2l; i++) {
            if(s2.charAt(i) == s3.charAt(i)){
                dp[0][i+1] = dp[0][i]+1;
            }else{
               break;
            }
        }
        while(i < s2l){
            dp[0][i+1] = dp[0][i];
            i++;
        }



        for (i = 1; i < s1l+1 ; i++) {
            for (int j = 1; j < s2l+1 ; j++) {
                dp[i][j] = Math.max(s3.charAt(dp[i-1][j])==s1.charAt(i-1)?dp[i-1][j]+1:dp[i-1][j],
                        s3.charAt(dp[i][j-1])==s2.charAt(j-1)?dp[i][j-1]+1:dp[i][j-1]);
            }
        }
        return s3.length() == dp[dp.length-1][dp[0].length-1];

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(solution.isInterleave(s1,s2,s3));
    }
}