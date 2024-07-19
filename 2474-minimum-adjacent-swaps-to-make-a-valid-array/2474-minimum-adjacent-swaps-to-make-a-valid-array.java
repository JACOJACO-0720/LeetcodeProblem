

import static java.lang.Math.random;

class Solution {
    public int minimumSwaps(int[] nums) {
        int[] small = new int[2];
        int[] big =new int[2];
        if(nums.length==1){
            return 0;
        }
        else{
            small[0] = nums[0];
            small[1] = 0;
            big[0] = nums[nums.length-1];
            big[1] = nums.length-1;
        }
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]<small[0]){
                small[0] = nums[i];
                small[1] = i;
            }
        }
        for (int i = nums.length-1; i >=0 ; i--) {
            if(nums[i]>big[0]){
                big[0] = nums[i];
                big[1] = i;
            }
        }
        if(small[1]<big[1]){
            return small[1] + nums.length -1 - big[1];
        }else{
            return small[1] + nums.length - big[1]-2;
        }
    }
}