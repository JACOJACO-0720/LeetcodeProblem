class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resLst = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if(i!=0 && nums[i] == nums[i-1]){
                continue;
            }
            int one = nums[i];
            if(one>0){
                break;
            }
            int two = i+1;
            int three = nums.length-1; 
            while(two<three){
                
                if(one + nums[two]+ nums[three] ==0){
                    ArrayList<Integer> al = new ArrayList<>();
                    al.add(one);al.add(nums[two]);al.add(nums[three]);
                    resLst.add(al);
                    two++;
                    three--;
                    while(two<three && nums[two]==nums[two-1]){
                        two++;
                    }
                    while(two<three && nums[three]== nums[three+1]){
                        three--;
                    }
                }else if(one + nums[two]+ nums[three] >0){
                    three--;
                }else{
                    two++;
                }
            }

        }

        return resLst;
    }
}