class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.isEmpty()){
            return 0;
        }
        int left = 0; int right = 0;
        int max = 1;
        HashSet<Character> hs  = new HashSet<>();
        while(left<s.length()&&right<s.length()){
            char tmpchar = s.charAt(right);
            while(left<right && hs.contains(tmpchar)){
                hs.remove(s.charAt(left));
                left++;
            }
            hs.add(tmpchar);
            max = Math.max(right-left+1,max ); 
            right++;
        }
        return max;
    }
}