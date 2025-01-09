class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums.length==1){
            return 1;
        }
        int notusedzero = 0;
        int usedzero = 0;
        int max = 0;
        for(int num: nums){
            if(num ==0){
                
                
                usedzero = notusedzero + 1;
                max = Math.max(max, usedzero);
                notusedzero = 0;
            }else{
                notusedzero++;
                usedzero++;
                max = Math.max(max, usedzero);
                max = Math.max(max, notusedzero);
            }
        }
        return max;
    }
}