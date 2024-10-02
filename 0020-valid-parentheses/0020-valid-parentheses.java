class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<Character>();
        String leftStr = "({[";
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if(leftStr.indexOf(temp)!=-1){
                stk.add(temp);

            }else{
                char tmpstr = ' ';
                if(temp=='}'){
                    tmpstr='{';
                }else if(temp==']'){
                    tmpstr = '[';
                }else{
                    tmpstr ='(';
                }
                if(stk.isEmpty()||stk.peek()!=tmpstr){
                    return false;
                }else{
                    stk.pop();
                }
            }
        }
        if(stk.isEmpty()){
            return true;
        }
        return false;
    }
}