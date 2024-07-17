class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();
        if(s.isEmpty()){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }

        int curRes =1;
        int maxRes = 1;
        int left = 0;
        int right = 0;
        hs.add(s.charAt(0));
        right ++;

        while(right<s.length()){
            if(hs.contains(s.charAt(right))){
                hs.remove(s.charAt(left));
                left++;
                curRes--;
            }else{
                hs.add(s.charAt(right));
                curRes++;
                if(curRes>maxRes){
                    maxRes = curRes;
                }
                right++;

            }
        }
        return maxRes;
    }
}