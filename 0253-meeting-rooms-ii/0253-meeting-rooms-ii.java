import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new MyComparator());
        for (int i = 0; i < intervals.length; i++) {
            int[] temp = intervals[i];
            int[] begin = new int[2];
            begin[0] = temp[0];
            int[] end = new int[2];
            end[0] = temp[1];
            end[1] = 1;
            pq.add(begin);pq.add(end);
        }
        int cur = 0;
        int maxcur = 0;
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            if(temp[1] ==0){
                cur++;
                maxcur = Math.max(cur,maxcur);
            }else{
                cur--;
            }
        }
        return maxcur;

    }
    class MyComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            int tmp = Integer.compare(o1[0], o2[0]);
            if (tmp == 0) {
                tmp = Integer.compare(o2[1], o1[1]);
            }
            return tmp;
        }
    }
}