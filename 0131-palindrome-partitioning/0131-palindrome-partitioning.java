import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <=i; j++) {
                if(s.charAt(i)==s.charAt(i-j) && ((j-2>=0 && dp[i-1][j-2])||j==1)){
                    dp[i][j] = true;
                }
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        dfs(res, s, 0, new ArrayList<>(), dp);
        return res;

    }
    void dfs( List<List<String>> res, String s, int start ,List<String> temp, boolean[][] dp){
        if(start==s.length()){
            List<String> t = new ArrayList<>();
            for (int i = 0; i < temp.size(); i++) {
                String tmps = new String(temp.get(i));
                t.add(tmps);
            }
            res.add(t);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if(dp[i][i-start]){
                temp.add(s.substring(start,i+1));
                dfs(res, s, i+1, temp, dp);
                temp.remove(temp.size()-1);
            }
        }
        
    }
}