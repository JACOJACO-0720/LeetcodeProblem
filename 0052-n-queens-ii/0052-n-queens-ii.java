class Solution {
    int result = 0;
    public int totalNQueens(int n) {

        if(n == 0){
            return 1;
        }
        int[] hm = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            //hm.put(0,i);
            hm[0] = i;
            HelperFunction(hm, count+1,n);
            hm[0] = 0;
        }
        return result;
    }
    void HelperFunction(int[] hm, int count, int n ){
            if(count == n){
                result++;
            }else{
                for (int pos = 0; pos < n; pos++) {
                    boolean qualified = true;
                    for (int i = 0; i < count; i++) {
                        int temPos = hm[i];
                        if(temPos == pos || (count - i) == (pos - temPos)||(count - i) == -(pos - temPos) ){
                            qualified = false;
                            break;
                        }  
                    }
                    if(qualified){
                        hm[count] = pos;
                        HelperFunction(hm, count + 1,n);
                        hm[count] = 0;
                    }
                }
                    
            }
            
    }
}