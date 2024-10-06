class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<Integer> stk1 = new PriorityQueue<Integer>();
        PriorityQueue<Integer> stk2 = new PriorityQueue<Integer>();
        for(int[] trip: trips){
            for(int i = 0;i<trip[0];i++){
                stk1.add(trip[1]);
                stk2.add(trip[2]);
            }
        } 
        int cur = 0;
        while(!stk1.isEmpty() && !stk2.isEmpty()){
            if(stk1.peek()<stk2.peek()){
                stk1.poll();
                cur++;
                if(cur>capacity){
                    return false;
                }
            }else{
                stk2.poll();
                cur--;
            }
        }
        return true;

    }
}