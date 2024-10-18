import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer> > res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if(i!=0 && nums[i]==nums[i-1]){
                continue;
            }
            int first = nums[i];
            
            int left = i+1;
            int right = nums.length-1;
            int target = -1*first;
            while(left<right){
                int tempsum = nums[left] + nums[right];
                if(tempsum==target){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(first);temp.add( nums[left]);temp.add(nums[right]);
                    res.add(temp);

                    left++;
                    while(left<nums.length && nums[left]==nums[left-1]){
                        left++;
                    }

                }else if(tempsum<target){
                    left++;
                    while(left<nums.length && nums[left]==nums[left-1]){
                        left++;
                    }
                }else{
                    right--;
                    while(right>=0 && nums[right]==nums[right+1]){
                        right--;
                    }
                }

            }
        }
        return res;
    }
}