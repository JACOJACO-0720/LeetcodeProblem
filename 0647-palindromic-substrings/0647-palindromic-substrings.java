class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int left = i-1; int right = i+1;
            count++;
            while(left>=0&&right<s.length() && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
                count++;
            }
        }

        for (int i = 0; i < s.length()-1; i++) {
            int left = i; int right = i+1;
            while(left>=0&&right<s.length() && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
                count++;
            }
        }
        return count;
    }
}