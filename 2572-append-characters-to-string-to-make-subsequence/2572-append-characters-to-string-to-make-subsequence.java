class Solution {
    public int appendCharacters(String s, String t) {
        if(s.contains(t)) return 0;
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