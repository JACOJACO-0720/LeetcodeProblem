class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length()+1][2];
        dp[0][0] = 1;
        HashMap<Character, List<Integer>> hm  = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            List<Integer> tl = hm.getOrDefault(t.charAt(i), new ArrayList<Integer>());
            tl.add(i);
            hm.put(t.charAt(i), tl);
        }


        for (int i = 0; i < s.length(); i++) {
            char tmpchar = s.charAt(i);
            List<Integer> posilst = hm.get(tmpchar);
            if(posilst==null||posilst.isEmpty()){
                continue;
            }
            for(int posi: posilst){
                dp[posi+1][1] =  dp[posi+1][0] + dp[posi][0];
            }
            
            for (int j = 0; j < dp.length; j++) {
                dp[j][0] = Math.max(dp[j][1],dp[j][0]) ;
            }
        }


        return dp[t.length()][0];
    }
}