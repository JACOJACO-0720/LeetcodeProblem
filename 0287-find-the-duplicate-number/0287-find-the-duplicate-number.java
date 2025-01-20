class Solution {
    public int findDuplicate(int[] nums) {
        int position = 0;
        while (true) {
            if(nums[position] != nums[nums[position]-1]){
                swap(nums,position, nums[position]-1);
            }else{
                if(position==nums[position]-1){
                    position++;
                }else{
                    return nums[position]; 
                }
            }
        }
    }
    
    void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
         nums[y] = temp;
    }
}