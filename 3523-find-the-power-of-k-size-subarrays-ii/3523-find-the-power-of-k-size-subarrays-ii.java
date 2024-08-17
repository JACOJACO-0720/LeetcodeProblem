import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] resultsArray(int[] nums, int k) {
        if(k==1){
            return nums;
        }
        int[] res = new int[nums.length-k+1];
        HashMap<Integer, Integer> hm = new HashMap<>();
        boolean isbeforegood = false;
        for (int i = 0; i < k; i++) {

        }
        for (int i = 0; i < nums.length-k+1; i++) {
            if(isbeforegood== false){
                isbeforegood = true;
                for (int j = i+1; j < i+k ; j++) {
                    if(nums[j]-1!=nums[j-1]){
                        isbeforegood =false;
                        res[i] = -1;
                        break;
                    }
                }

                if(isbeforegood){
                    res[i] = nums[i+k-1];
                }

            }else{
                if(nums[i+k-1]-1!=nums[i+k-2]){
                    isbeforegood =false;
                    res[i] = -1;
                }else{
                    res[i] = nums[i+k-1];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = {1,2,3,4,3,2,5};
        System.out.println(Arrays.stream(solution.resultsArray(input,3)).toArray());
    }
}