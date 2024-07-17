class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }

        int res = 1;
        int left = 0;
        int right = 0;
        int current = 1;
        int[] table = new int[200];
        table[s.charAt(0)] = 1;
        while(right<s.length()){
                if(right+1 < s.length() && table[s.charAt(right+1)]!=0){
                    if(left==right){
                        table[s.charAt(right)] = 0;
                        table[s.charAt(right+1)] = 1;
                        left++;
                        right++;
                        current = 1;
                    }else{
                        table[s.charAt(left)]= 0;
                        left++;
                        current--;
                    }
                }else{
                    if(right+1==s.length()){
                        return res;
                    }else{
                        table[s.charAt(right+1)]=1;
                        current++;
                        right++;
                        res = Math.max(res,current);
                    }

                }
            

        }
        return res;
    }
}