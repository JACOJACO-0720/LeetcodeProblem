class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[21];
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> lst = new ArrayList<>();
            for(int num:nums){
                if(!visited[num+10]){
                    visited[num+10] = true;
                    lst.add(num);
                    helperFunction(res, visited, nums, lst);
                    visited[num+10] = false;
                    lst.remove(lst.size()-1);
                }

            }
        return res;
    }
    void helperFunction(List<List<Integer>> res, boolean[] visited,int[] nums,ArrayList<Integer> lst){
        if(lst.size()==nums.length){
            List<Integer> r = new ArrayList<>();
            for(int l:lst){
                r.add(l);
            }
            res.add(r);
            return ;
        }else{
            for(int num:nums){
                if(!visited[num+10]){
                    visited[num+10] = true;
                    lst.add(num);
                    helperFunction(res, visited, nums, lst);
                    visited[num+10] = false;
                    lst.remove(lst.size()-1);
                }

            }
        }
    }

}