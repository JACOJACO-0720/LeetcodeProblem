class Solution {
    public int strStr(String haystack, String needle) {
        int[] lps = helperFunction(needle);
        int h = 0;
        int n = 0;
        while(h<haystack.length()){
            if(haystack.charAt(h)==needle.charAt(n)){
                h++;
                n++;
                if(n==needle.length()){
                    return h-n;
                }
            }else{
                if(n!=0){
                    n = lps[n-1];

                }else{
                    h++;
                }
                
            }
        }
        return -1;
    }
    int[] helperFunction(String needle){
        int[] lps = new int[needle.length()];
        if(lps.length==1){
            return lps;
        }
        int left = 0;
        int right = 1;
        while(right<needle.length()){
            if(needle.charAt(left)==needle.charAt(right)){
                lps[right] = left+1;
                right++;
                left++;
            }else{
                if(left==0){
                    lps[right] = 0;
                    right++;
                }else{
                    left = lps[left-1];
                }
            }
        }
        return lps;
    }
}