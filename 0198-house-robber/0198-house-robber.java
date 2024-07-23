class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }


        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);

        for(int i=2;i<nums.length;i++){
                dp[i] = Math.max(dp[i-1] , dp[i-2]+nums[i]);
        }
        return dp[dp.length-1];
    }
}



// 2,7,9,100,1
// 900 100 10 1 10 100 1000

// 定义dp表达式
// dp[i]的含义是前i个房子最多能偷多少的钱
// 如果前一个偷了的话，下一个肯定不能偷，如果前一个没偷的话，后面的可以选择偷或者不偷

// dp[i] = max(dp[i],dp[i-1]+nums[i]) if 前面的没偷

// dp[i] = dp