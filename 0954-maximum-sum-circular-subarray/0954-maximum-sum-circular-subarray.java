class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int middle = findmiddle(nums);
        int sides = findsides(nums);
        return Math.max(middle, sides);
    }

    int findmiddle(int[] nums){
        int sum = nums[0];
        int cursum = nums[0]<0?0:nums[0];
        for (int i = 1; i < nums.length; i++) {
            cursum+=nums[i];
            if(cursum>sum){
                sum = cursum;
            }
            if(cursum<0){
                cursum = 0;
            }
        }
        return sum;
    }
    
     int findsides(int[] nums){
        int sum = nums[0];
        int cursum = nums[0]>0?0:nums[0];
        int length = nums[0]>0?0:1;
        for (int i = 1; i < nums.length; i++) {

            cursum+=nums[i];
            length++;
            if(cursum<sum){
                sum = cursum;
            }
            if(cursum>0){
                length = 0;
                cursum = 0;
            }
        }
        int min = Integer.MAX_VALUE;
        int revsum = 0;
        for(int num:nums){
            if(num<min){
                min = num;
            }
            revsum+=num;
        }
        if(length!=nums.length){
             return revsum-sum;
        }
       return revsum-sum + min;
     }
}