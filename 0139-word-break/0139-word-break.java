import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i < s.length()+1; i++) {
            for(String str: wordDict){
                if(str.length()<= i && dp[i-str.length()]==true && str.equals(s.substring(i-str.length(),i ))){
                    dp[i]=true;
                }
            }
        }
        return dp[dp.length-1];

    }
}