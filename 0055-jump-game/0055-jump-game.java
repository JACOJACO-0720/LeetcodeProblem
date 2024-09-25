class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i<=max){
                max = Math.max(i+nums[i], max);
            }
            if(max>=nums.length-1){
                return true;
            }
        }
        return false;
        
    }
}