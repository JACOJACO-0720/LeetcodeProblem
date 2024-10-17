class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[]=new int[nums.length+1];
        Arrays.fill(dp,1);
        
        for(int i=1;i<nums.length;++i){
            int max=Integer.MIN_VALUE;
            for(int j=0;j<i;++j){
                if(nums[j]<nums[i]){
                    max=Math.max(max,dp[j]+1);
                    dp[i]=max;
                }
            }
            // System.out.println(dp[i]);
        }
        int max=1;
        for(int i=0;i<dp.length;++i)max=Math.max(max,dp[i]);
        return max;
    }
}