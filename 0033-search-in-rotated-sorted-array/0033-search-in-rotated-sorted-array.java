class Solution {
    public int search(int[] nums, int target) {
        int left = 0; int right =nums.length-1;
        int leftleft = nums[0]; int rightright = nums[nums.length-1];
        while(left<=right){
            int mid = left +(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }else{
                if(nums[mid]<target){
                    if(nums[mid]>=leftleft && target>=leftleft){
                        left=mid+1;
                    }else if(nums[mid]<=rightright && target<=rightright){
                        left = mid+1;
                    }else{
                        right = mid-1;
                    }
                }else{
                    if(nums[mid]>=leftleft && target>=leftleft){
                        right = mid-1;
                    }else if(nums[mid]<=rightright && target<=rightright){
                         right = mid-1;
                    }else{
                        left = mid+1;
                    }
                }
            }
        }
        return -1;
    }
}