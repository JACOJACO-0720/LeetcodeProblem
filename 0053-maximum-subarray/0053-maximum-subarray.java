class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==1)return nums[0];
        int SumMax = nums[0];
        int curMax = nums[0]<0?0:nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]<0){
                curMax = curMax +nums[i];
                if(curMax>SumMax){
                    SumMax = curMax;
                }
                if(curMax<0){
                    curMax = 0;
                }
            }else{
                curMax = curMax +nums[i];
                if(curMax>SumMax){
                    SumMax = curMax;
                }
            }
        }
        return SumMax;
    }
}