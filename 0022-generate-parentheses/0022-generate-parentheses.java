class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n==1){
            res.add("()");
            return res;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("()");
        helperFunction(sb, n-1,res,1);

        helperFunction(sb, n-1,res,2);
        return res;
    }
    void helperFunction(StringBuilder sb, int n, List<String> res, int posi ){
        if(n==1){
            sb.insert(posi,"()");
            res.add(sb.toString());
            sb.deleteCharAt(posi);
            sb.deleteCharAt(posi);
            return;
        }

        sb.insert(posi,"()");
        for (int i = posi+1; i <= sb.length(); i++) {
            helperFunction(sb, n-1,res,i);
        }
        
        //helperFunction(sb, n-1,res,posi+2);
        sb.deleteCharAt(posi);
        sb.deleteCharAt(posi);

    }
}