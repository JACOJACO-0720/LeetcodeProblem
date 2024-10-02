class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        List<Integer> tmplst = new ArrayList<>();
        dfs(nums, visited, tmplst,res);
        return res;

    }
    void dfs(int[] nums, boolean[] visited, List<Integer> tmplst,List<List<Integer>> res){
if (nums.length == tmplst.size()) {
    res.add(new ArrayList<>(tmplst)); 
    return;
}
        for(int i =0;i<nums.length;i++){
            if(visited[i]){
                continue;
            }else{
                if( i>0 && !visited[i-1] && nums[i-1] ==nums[i]){
                    continue;
                }else{
                    visited[i]=true;
                    tmplst.add(nums[i]);
                    dfs(nums, visited, tmplst,res);
                    tmplst.remove(tmplst.size()-1);
                    visited[i]=false;
                }
            }
        }
    }
}