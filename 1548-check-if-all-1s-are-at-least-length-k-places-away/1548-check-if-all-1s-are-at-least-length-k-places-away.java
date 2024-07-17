class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int current1 = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==1){
                if(current1==-1){
                    current1 = i;
                }else{
                    if(i-current1-1<k){
                        return false;
                    }else{
                        current1 = i;
                    }
                }
            }
        }
        return true;
    }
}