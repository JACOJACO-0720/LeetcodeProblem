import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int totalNum = 0 ;
        HashSet<Integer> hs = new HashSet<>();
        for(int num : nums){
            if(!hs.contains(num)){
                totalNum++;
                hs.add(num);
            }
        }
        int res = 0;
        int curNum = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int left = 0; int right = 0;
        hm.put(nums[0], 1);
        curNum=1;
        for (left = 0; left < nums.length; left++) {
            if(left!=0){
                int tmpNum = hm.get(nums[left-1]);
                hm.put(nums[left-1], tmpNum-1);
                if(tmpNum == 1){
                    curNum--;
                }

            }
            while(curNum<totalNum && right<nums.length-1){
                right++;
                int tmpint = hm.getOrDefault(nums[right],0);
                if(tmpint==0){
                    curNum++;
                }
                hm.put(nums[right], tmpint+1);
            }
            if(curNum==totalNum){
                res += (nums.length - right);
            }
            
        }

        return res;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = {1,3,1,2,2};
        System.out.println(solution.countCompleteSubarrays(input));
    }
}