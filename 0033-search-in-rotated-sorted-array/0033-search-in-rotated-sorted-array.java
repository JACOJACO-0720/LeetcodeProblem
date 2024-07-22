class Solution {
    public int search(int[] nums, int target) {
        int left = 0;int right = nums.length-1;
        while(right>=left){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }else{
                if(nums[mid]>=nums[left]&&nums[mid]>nums[right]){
                    if(nums[mid]<target){
                        left = mid+1;
                        continue;
                    }else{
                        if(target>=nums[left]){
                            right = mid-1;
                            continue;
                        }else{
                            left = mid+1;
                            continue;
                        }
                    }
                }else{
                    if(nums[mid]>target){
                        right = mid-1;
                        continue;
                    }else{
                        if(target<=nums[right]){
                            left = mid+1;
                            continue;
                        }else{
                            right = mid-1;
                            continue;
                        }
                    }
                }
            }
        }
        return -1;
    }
}