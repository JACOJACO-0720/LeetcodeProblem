class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int num:nums){
            if (nums[Math.abs(num)-1]<0){
                res.add(Math.abs(num));
            }else{
                nums[Math.abs(num)-1] = -nums[Math.abs(num)-1];
            }
        }
        return res;
    }
}