class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        if(nums.length==1)return nums[0];

        int sum = 0;
        for(int num:nums){
            sum+=num;
        }
        int SumMax = nums[0];
        int curMax = nums[0]<0?0:nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]<0){
                curMax = curMax +nums[i];
                if(curMax>SumMax){
                    SumMax = curMax;
                }
                if(curMax<0){
                    curMax = 0;
                }
            }else{
                curMax = curMax +nums[i];
                if(curMax>SumMax){
                    SumMax = curMax;
                }
            }
        }

        if(nums.length==1)return nums[0];

        int length =1;;
        int SumMin = nums[0];
        int curMin;
        int minmin = nums[0];
        if(nums[0]>0){
            curMin = 0;
            length =0;
        }else{
            curMin = nums[0];

        }
        for (int i = 1; i < nums.length; i++) {
            if(minmin>nums[i]){
                minmin = nums[i];
            }
            if(nums[i]>0){
                length++;
                curMin = curMin + nums[i];
                if(curMin<SumMin){
                    SumMin = curMin;
                }
                if(curMin > 0){
                    curMin = 0;
                    length = 0;
                }
            }else{
                length++;
                curMin = curMin + nums[i];
                if(curMin < SumMin){
                    SumMin = curMin;
                }
            }
        }

        int sec;
        if(length == nums.length){
            sec = sum - minmin;
        }else{
            sec = sum-SumMin;
        }

        return Math.max(SumMax,sec);
    }
}