class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helperFunction(s, 0, new StringBuilder(),0,res);

        return res;

    }
    void helperFunction(String s, int count, StringBuilder sb, int posi,List<String> res){
        if(count==4){
            if(posi ==s.length()){
                res.add(new String(sb.deleteCharAt(sb.length()-1).toString()));
                return;
            }else{
                return;
            }
        }

        for(int i =posi; i < Math.min(posi+3,s.length());i++){
            if(i!=posi && s.charAt(posi)=='0'){
                continue;
            }
            Integer in = Integer.valueOf(s.substring(posi,i+1));
            if(in<=255){ 
                sb.append(String.valueOf(in));
                sb.append('.');
                helperFunction(s, count + 1, sb,i+1,res);
                sb.deleteCharAt(sb.length()-1);
                while(sb.length()!=0 && sb.charAt(sb.length()-1)!='.'){
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }

    }
}