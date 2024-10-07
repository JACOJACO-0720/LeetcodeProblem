class Solution {
    public boolean search(int[] nums, int k) {

        int low =0, high = nums.length-1;

        while(low<=high){

            int mid = low + (high-low)/2;

            if(nums[mid]==k) return true;

            if(nums[low]==nums[mid]&& nums[mid]==nums[high]) {
                low++;
                high--;
                continue;
            }

            else if (nums[low]<= nums[mid]){

                if(k>=nums[low] && k<= nums[mid]){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else{

                if(k>=nums[mid] && k<=nums[high]){
                    low= mid+1;
                }
                else{
                    high = mid-1;
                }
            }
        }
        return false;

        
    }
}