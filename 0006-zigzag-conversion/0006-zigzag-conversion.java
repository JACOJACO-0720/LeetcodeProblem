class Solution {
    public String convert(String s, int numRows) {
        //2 4
        if(numRows==1){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i=i+(numRows-1)*2) {
            sb.append(s.charAt(i));
        }
        for (int i = 1; i < numRows-1; i++) {
            for (int j = 0; j < s.length()+numRows; j =j+(numRows-1)*2) {
                if(j-i>=0 && j-i<s.length()){
                    sb.append(s.charAt(j-i));
                }
                if(j+i<s.length()){
                    sb.append(s.charAt(j+i));
                }
                
            }
        }
        for (int i = numRows-1; i < s.length(); i=i+(numRows-1)*2) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}