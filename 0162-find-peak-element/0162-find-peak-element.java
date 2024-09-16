class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0; int right = nums.length-1;
        while(left<=right){
            int mid = left +(right-left)/2;
            int temp = nums[mid];
            boolean leftValid = mid-1<0?true:(nums[mid-1]<temp);
            boolean rightValid = mid+1>=nums.length?true: (nums[mid+1]<temp);
            if(leftValid&&rightValid){
                return mid;
            }else{
                if(!leftValid){
                    right = mid-1;
                }else{
                    left  = mid+1;
                }
            }
        }
        return -1;
    }
}