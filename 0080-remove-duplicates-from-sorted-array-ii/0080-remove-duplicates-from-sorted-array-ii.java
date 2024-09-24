class Solution {
    public int removeDuplicates(int[] nums) {
        int cur = 0; 
        int curNum = Integer.MIN_VALUE;
        int count = 0;
        int totalcount = 0;
        while(cur<nums.length){
            int temp = nums[cur];
            count++;
            if(temp!=curNum){
                curNum = temp;
                count = 1;
                cur++;
            }else{
                if(count>2){
                    nums[cur] = Integer.MAX_VALUE;
                    cur++;
                    totalcount++;
                }else{
                    cur++;
                }
            }
        }
        int left = 0;
        int right = 0;
        while(right<nums.length && left<nums.length){
            while(left<nums.length && nums[left]!=Integer.MAX_VALUE){
                left++;
            }
            if(left==nums.length){
                break;
            }
            right = left+1;
            if(right==nums.length){
                break;
            }
            while(right<nums.length && nums[right]==Integer.MAX_VALUE){
                right++;
            }
            if(right==nums.length){
                break;
            }
            if(nums[left]==Integer.MAX_VALUE&&nums[right]!=Integer.MAX_VALUE){
                int temp = nums[right];
                nums[left] = temp;
                nums[right] = Integer.MAX_VALUE;
            }


        }
        return nums.length-totalcount;
    }
}