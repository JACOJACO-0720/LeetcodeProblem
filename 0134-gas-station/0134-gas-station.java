class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //-2, -2, -2, 3, 3
        int sum = 0;
        int[] dis = new int[cost.length*2];
        for (int i = 0; i < dis.length/2; i++) {

            dis[i] = gas[i]-cost[i];
            dis[i+cost.length] = dis[i];
            sum += dis[i];
        }
        int curlength = 0 ;
        int curIndex = 0;
        int current = 0;
        if(sum<0){
            return -1;
        }else{
            for (int i = 0; i < dis.length; i++) {
                current+=dis[i];
                if(current<0){
                    current = 0;
                    curlength = 0;
                    continue;
                }else {
                    curlength++;
                    if(curlength==dis.length/2){
                        return i-dis.length/2+1;
                    }
                    continue;
                }
                
            }
        }
        return -1;
    }
}