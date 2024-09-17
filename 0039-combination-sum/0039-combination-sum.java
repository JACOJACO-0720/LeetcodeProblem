class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lst = new ArrayList<>();
        Arrays.sort(candidates);
        helperfunction(candidates, target, lst, new ArrayList<>(),0);
        return lst;
    }
    void helperfunction(int[] candidates, int target, List<List<Integer>> lst, ArrayList<Integer> al, int startpoint){
        if(target==0){
            List<Integer> clonelst = new ArrayList<>();
            for (int i = 0; i < al.size(); i++) {
                clonelst.add(al.get(i));
            }
            lst.add(clonelst);
        }
        for (int i = startpoint; i < candidates.length; i++) {
            if(target<candidates[i]){
                continue;
            }else{
                al.add(candidates[i]);
                helperfunction(candidates, target - candidates[i] , lst, al, i);
                al.remove(al.size()-1);
            }
        }

    }

    
}