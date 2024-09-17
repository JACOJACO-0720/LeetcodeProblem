class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int localmax = nums[0]<0?0:nums[0];
        for (int i = 1; i < nums.length; i++) {
            localmax = localmax+nums[i];
if(localmax>max){
                    max = localmax;
                }
            if(localmax<0){
                localmax = 0;
            }

        }
        return max;
    }
}