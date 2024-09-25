class Solution {
    public int jump(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        if(nums.length==1){
            return 0;
        }
        ad.add(0);
        visited[0] = true;
        int res = 0; 
        while(!ad.isEmpty()){
                res++;
            int size = ad.size();
            for(int i =0;i<size;i++){
                int temp = ad.poll();
                if(temp==nums.length-1){
                    return res;
                }
                int tempnum = nums[temp];
                for (int j = 1; j <= tempnum; j++) {
                if(temp+j==nums.length-1){
                    return res;
                }
                    if(!visited[temp+j]){
                        visited[temp+j]= true;
                        ad.add(temp+j);
                    }
                }
            }
        
        }
        return -1;
    }
}