class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] maps = new int[26];
        for(int task: tasks){
            maps[task-'A']++;
        }

        PriorityQueue<int[]> pq =new PriorityQueue<>((n1,n2)->(Integer.compare(n1[0],n2[0])));

        for(int map: maps){
            if(map!=0){
            int[] temp = new int[2];temp[0] = 0;temp[1] = map;
            pq.add(temp);
            }

        }
        int time  = 0;
        while(!pq.isEmpty()){
            if(pq.peek()[0] >time){
                time  = pq.peek()[0];
            }else{
                int[] tmp = pq.poll();
                tmp[1]--;
                if(tmp[1]!=0){
                    tmp[0] = ( tmp[0]+n+1) ;
                    pq.add(tmp);
                }
                time++;
            }
        }
        return time;


    }

}