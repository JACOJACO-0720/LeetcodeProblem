class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;int right = nums.length-1;
        while(left<=right){
            int mid = left+ (right-left)/2;
            if(((mid-1<0)||nums[mid-1]<nums[mid] )&& (mid+1>=nums.length || nums[mid+1]<nums[mid])){
                return mid;
            }else if(mid-1>=0 && nums[mid-1]>nums[mid]){
                right= mid-1;
            }else{
                left = mid+1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = {1,2};
        System.out.println(solution.findPeakElement(input));
    }
}