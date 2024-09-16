class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left =0; int right = nums.length-1;
        while(left<=right){
            int mid = left +(right-left)/2;
            if(nums[mid]==target){
                int resleft = mid; int resright = mid;
                int res = nums[mid];
                while(resleft -1 >=0 && nums[resleft-1]==res ){
                    resleft--;
                }
                while(resright +1 < nums.length && nums[resright+1]==res ){
                    resright++;
                }
                int[] fres = new int[2];
                fres[0] = resleft; fres[1] = resright;
                return fres;
            }else{
                if(nums[mid]>target){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
        }
        int[] invalid = new int[2];
        invalid[0] = -1; invalid[1] = -1;
        return invalid;
    }
}