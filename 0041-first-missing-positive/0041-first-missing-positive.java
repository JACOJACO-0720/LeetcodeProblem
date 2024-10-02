class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> hs= new HashSet<>();
        int cur = 1;
        for(int i =0;i<nums.length;i++){
            if(nums[i]<cur || nums[i]<=0){
                continue;
            }else if(nums[i] == cur){
                hs.add(cur);
                cur++;
                while(hs.contains(cur)){
                    cur++;
                }
            }else {
                hs.add(nums[i]);
            }
        }
        return cur;
    }
}