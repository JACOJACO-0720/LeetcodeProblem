class Solution {
    public int calculate(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!=' '){
                sb.append(s.charAt(i));
            }
        }
        s = sb.toString();
        Stack<Integer> stk = new Stack<>();
        Stack<Character> sym = new Stack<>();
        int left = 0; int right = 0;
        while(right<s.length()){
            char temp = s.charAt(right);
            if(temp==' '){
                continue;
            }
            if((temp>='0' && temp<='9')){
                if(right+1 < s.length() && (s.charAt(right+1)>='0' && s.charAt(right+1)<='9')){
                    right++;
                }else{
                    int current = Integer.valueOf(s.substring(left,right+1));
                    if(sym.isEmpty()){
                        stk.add(current);
                    }else{
                        char symbol = sym.peek();
                        if(symbol=='+'){
                            stk.add(current);

                        }else if(symbol=='-'){
                            stk.add(current);
                        }else if(symbol == '*'){
                            sym.pop();
                            int form = stk.pop();
                            int tempres = form * current;
                            stk.add(tempres);
                        }else{
                             sym.pop();
                            int form = stk.pop();
                            int tempres = form / current;
                            stk.add(tempres);
                        }
                    }
                    right++;
                    left = right;
                }
            }else{
                sym.add(temp);
                right++;
                left = right;
            }
        }
        
        // Stack<Integer> stk = new Stack<>();
        // Stack<Character> sym = new Stack<>();

        int res = 0;
        while(!stk.isEmpty()){
            if(sym.isEmpty()){
                res += stk.pop();
            }
            
            else if(sym.peek()=='+'){
                sym.pop();
                res += stk.pop();
            }else{
                sym.pop();
                res-=stk.pop();
            }
        }
        return res;
    }
}