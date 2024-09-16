class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int count = 0;
        int[][] pc = new int[profits.length][2];
        for (int i = 0; i < pc.length; i++) {
            pc[i][0] = capital[i];
            pc[i][1] = profits[i];

        }
        int posi = 0;
        Arrays.sort(pc, (int[] n1, int[] n2)->Integer.compare(n1[0], n2[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] n1, int[] n2)->Integer.compare(n2[1], n1[1]));
        while(count<k){

            while(posi<pc.length && w >= pc[posi][0]){
                pq.add(pc[posi]);
                posi++;
            }
            if(pq.isEmpty()){
                break;
            }
            int[] temp = pq.poll();
            w += temp[1];
            count++;

        }
        return w;
    }
}