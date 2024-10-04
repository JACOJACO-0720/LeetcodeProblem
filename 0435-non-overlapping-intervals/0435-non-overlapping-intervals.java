import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;
        Arrays.sort(intervals, new MyComparator());
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] temp = intervals[i];
            if(temp[0]<current[1]){
                count++;
                if(temp[1] < current[1]){
                    current = temp;
                }
            }else{
                current = temp;
            }
        }
        return count;
    }

    class MyComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            int res = Integer.compare(o1[0],o2[0]);
            if(res==0){
                return Integer.compare(o1[1], o2[1]);
            }else{
                return res;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //[[1,100],[11,22],[1,11],[2,12]]
        int[][] input = {{1,100},{11,22},{1,11},{2,12}};
        System.out.println(solution.eraseOverlapIntervals(input));
    }
}