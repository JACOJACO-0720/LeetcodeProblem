class Solution {
    public int findMin(int[] nums) {
        int left = 0 ;int right = nums.length-1;
        int leftleft = nums[0]; int rightright = nums[nums.length-1];
        if(rightright>leftleft){
            return nums[left];
        }
                while(left<=right){
            int mid = left + (right-left)/2;
            if(mid-1>=0 && mid+1<nums.length && nums[mid-1]>nums[mid] && nums[mid+1]>nums[mid]){
                return nums[mid];
            }else{
                if(nums[mid]>=leftleft){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
            return nums[nums.length-1];


    }
}