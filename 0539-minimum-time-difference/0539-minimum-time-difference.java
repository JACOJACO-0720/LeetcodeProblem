class Solution {
    public int findMinDifference(List<String> timePoints) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i =0;i<timePoints.size();i++){
            String tempStr = timePoints.get(i);
            String[] t = tempStr.split(":");
            int tmpTime = Integer.valueOf(t[0])*60 + Integer.valueOf(t[1]);
            pq.add(tmpTime); 
        }
        int dis = Integer.MAX_VALUE;
        int smallest = pq.peek();
        int left = pq.poll();
        int right = -1;
        while(!pq.isEmpty()){
            right = pq.poll();
            int tmpdis = right-left;
            if(tmpdis<dis){
                dis = tmpdis;
            }
            left = right;
        }

        //handle special
        if(Math.abs(right-smallest- 24*60 )<dis){
            dis = Math.abs(right-smallest- 24*60);
            
        }
        return dis;


    }
}