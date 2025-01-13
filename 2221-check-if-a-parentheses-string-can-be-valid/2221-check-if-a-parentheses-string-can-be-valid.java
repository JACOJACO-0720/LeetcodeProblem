class Solution {
    public boolean canBeValid(String s, String locked) {
        int[][] dp = new int[s.length()+1][2]; //min max
        dp[0][0] = 0;
        dp[0][1] = 0;
        
        for(int i =0;i< s.length();i++){
            char islocked = locked.charAt(i);
            char par = s.charAt(i);
            if(islocked == '1'){
                if(par == '('){
                    dp[i+1][1] = dp[i][1]+1;
                    dp[i+1][0] = dp[i][0]+1;
                }else{
                    dp[i+1][1] = dp[i][1]-1;
                    dp[i+1][0] = dp[i][0]-1;
                    if(dp[i+1][0]==-1){
                        dp[i+1][0] = 1;
                    }
                    if(dp[i+1][1] <0 || dp[i+1][0]>dp[i+1][1]){
                        return false;
                    }
                }
            }else{
                    dp[i+1][1] = dp[i][1]+1;
                    dp[i+1][0] = dp[i][0]-1;
                    if(dp[i+1][0]==-1){
                        dp[i+1][0] = 1;
                    }
                    if(dp[i+1][1] <0 ){
                        return false;
                    }

            }
        }
        if(dp[dp.length-1][1]>=0 && dp[dp.length-1][0]<=0){
            return true;
        }
        return false;


        
    }
}