class Solution {
    public String longestPalindrome(String s) {
        if(s==null){
            return null;
        }
        int maxLength = 1;
        String result = String.valueOf(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {

            int left = i-1;int right = i+1;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                if( right -left + 1 > maxLength){
                    maxLength = right-left+1;
                    result= s.substring(left,right+1);
                }
                left--;
                right++;
            }
            
        }


        for (int i = 0; i < s.length()-1; i++) {

            int left = i-1;int right = i+2;
            if(s.charAt(i)==s.charAt(i+1)){
                if( 2 > maxLength){
                    maxLength = 2;
                    result= s.substring(i,i+2);
                }

                
                while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                if( right -left + 1 > maxLength){
                    maxLength = right-left+1;
                    result= s.substring(left,right+1);
                }
                left--;
                right++;
            }
            }
            
            
        }
        return result;

    }
}
