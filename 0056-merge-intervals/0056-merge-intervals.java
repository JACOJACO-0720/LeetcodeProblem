import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals,(n1,n2)->(Integer.compare(n1[0], n2[0])));
        ArrayList<int[]> al = new ArrayList<>();
        int[] cur = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] temp = intervals[i];
            if(temp[0]>cur[1]){
                al.add(cur);
                cur = temp;
            }else{
                cur[1] = Math.max(cur[1], temp[1]);
            }
        }
        al.add(cur);

        return al.toArray(new int[al.size()][]);

    }
}