class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int numOfBricks = 0;
        for (int i = 1; i < heights.length; i++) {
            if(heights[i]<=heights[i-1]){
                continue;
            }else{
                int temp = heights[i]-heights[i-1];
                pq.add(temp);
                if(pq.size()>ladders){
                    int tempSmall = pq.poll();
                    numOfBricks += tempSmall;
                    if(numOfBricks>bricks){
                        return i-1;
                    }
                }
            }
        }
        return heights.length-1;
    }
}