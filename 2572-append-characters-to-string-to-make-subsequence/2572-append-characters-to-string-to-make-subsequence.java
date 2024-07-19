class Solution {
    public int appendCharacters(String s, String t) {
        int curS = 0;
        int curT = 0;
            while(curS<s.length() && curT<t.length()){
                if(s.charAt(curS)==t.charAt(curT) ){
                    curS++;
                    curT++;
                }else{
                    curS++;
                }
            }
            return t.length() - curT;
        
    }
}