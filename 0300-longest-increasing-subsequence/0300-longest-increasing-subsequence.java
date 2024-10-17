class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        return dfs(dp, 0 ,nums, Integer.MIN_VALUE);

    }
    int dfs(int[] dp, int x, int[] nums, int prev){
        if(x == nums.length){
            return 0;
        }

        if(nums[x]<=prev){
            return dfs(dp, x+1, nums , prev) ;
        }else{
            if(dp[x]!=0){
                return Math.max(dp[x], dfs(dp, x+1, nums , prev)) ;
            }else{
                dp[x] = Math.max(dfs(dp, x+1, nums , nums[x])+1, dfs(dp, x+1, nums , prev)) ;
                return dp[x];
            }
        }


    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = {10,9,2,5,3,7,101,18};
        System.out.println(solution.lengthOfLIS(input));

    }
}