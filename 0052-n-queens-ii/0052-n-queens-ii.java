class Solution {
    int result = 0;
    public int totalNQueens(int n) {

        if(n == 0){
            return 1;
        }
        HashMap<Integer, Integer> hm  = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            hm.put(0,i);
            HelperFunction(hm, count+1,n);
            hm.remove(0);
        }
        return result;
    }
    void HelperFunction(HashMap<Integer, Integer> hm, int count, int n ){
            if(count == n){
                result++;
            }else{
                for (int pos = 0; pos < n; pos++) {
                    boolean qualified = true;
                    for (int i = 0; i < count; i++) {
                        int temPos = hm.get(i);
                        if(temPos == pos || (count - i) == (pos - temPos)||(count - i) == -(pos - temPos) ){
                            qualified = false;
                            break;
                        }  
                    }
                    if(qualified){
                        hm.put(count,pos);
                        HelperFunction(hm, count + 1,n);
                        hm.remove(count);
                    }
                }
                    
            }
            
    }
}