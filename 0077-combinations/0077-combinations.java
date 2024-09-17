class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> r = new ArrayList<>();
        helperfunction(n,k,1,0,res,r);
        return res;
    }
    void helperfunction(int n , int k, int current,int currentnum, List<List<Integer>> res, ArrayList<Integer> r){
        if(currentnum == k){
            List<Integer> tr = new ArrayList<>();
            for (int i = 0; i <r.size(); i++) {
                tr.add(r.get(i));
            }
            res.add(tr);
            return;
        }

        for (int i = current; i <= n; i++) {
            r.add(i);
            helperfunction(n, k, i+1, currentnum+1, res, r);
            r.remove(r.size()-1);
        }
    }
}