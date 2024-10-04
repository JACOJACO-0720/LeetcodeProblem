import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        //dfs
        List<Integer> tmplst = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(res,k,n, tmplst,0);
        return res;

    }
    void dfs(List<List<Integer>> res, int k ,int n, List<Integer> tmplst, int cur){
        if(n==0){
            if (k == 0) {
                res.add(new ArrayList<>(tmplst));
            }
            return;
        }else{
            
            for (int i = cur+1; i <= 9 ; i++) {
                tmplst.add(i);
                dfs(res,k-1,n-i, tmplst,i);
                tmplst.remove(tmplst.size()-1);
            }
        }
    }


}