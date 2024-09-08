class Solution {
    public int reverse(int x) {
        if(x==0){
            return 0;
        }
        boolean ispositive = false;
        if(x>0){
            ispositive = true;
        }
        x=Math.abs(x);
        StringBuilder sb = new StringBuilder( String.valueOf(x));

        sb = sb.reverse();
        while(sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        if(sb.length()<10){
            int flag = ispositive?1:-1;
            return Integer.valueOf(sb.toString())*flag;
        }else{
            if(ispositive){
                String max = String.valueOf(Integer.MAX_VALUE);
                for (int i = 0; i < max.length(); i++) {
                    if(max.charAt(i)<sb.charAt(i)){
                        return 0;
                    }else if(max.charAt(i)==sb.charAt(i)){
                        continue;
                    }else{
                        return  Integer.valueOf(sb.toString());
                    }
                    
                }
                return  Integer.valueOf(sb.toString());
            }else{
                String max = String.valueOf(Integer.MIN_VALUE).substring(1);
                for (int i = 0; i < max.length(); i++) {
                    if(max.charAt(i)<sb.charAt(i)){
                        return 0;
                    }else if(max.charAt(i)==sb.charAt(i)){
                        continue;
                    }else{
                        return  Integer.valueOf(sb.toString())*(-1);
                    }
                   
                }
                 return  Integer.valueOf(sb.toString())*(-1);
            }
        }


    }
}