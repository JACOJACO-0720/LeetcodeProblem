class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(new ArrayList<>(), 0, nums, res);
        return res;

    }
    void dfs(List<Integer> lst, int start, int[] nums, List<List<Integer>> res){
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < lst.size(); i++) {
            al.add(lst.get(i));
        }
        res.add(al);
        if(start == nums.length){
            return;
        }
        for (int i = start; i < nums.length; i++) {
            lst.add(nums[i]);
            dfs(lst, i+1, nums, res);
            lst.remove(lst.size()-1);
        }
    }
}