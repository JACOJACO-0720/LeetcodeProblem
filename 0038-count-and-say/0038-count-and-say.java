class Solution {
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }else{
            return helperFunction(countAndSay(n-1));
        }
    }

    String helperFunction(String str){
        StringBuilder sb = new StringBuilder();
        int count =1;
        char beforeChar = str.charAt(0);
        for(int i =1;i<str.length();i++){
            char curChar = str.charAt(i);
            if(curChar==beforeChar){
                count++;
            }else{
              
                sb.append(count).append(beforeChar);
                  beforeChar = str.charAt(i);
                  count=1;
            }
        }
        sb.append(count).append(beforeChar);
        return sb.toString();
    }
}