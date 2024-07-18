import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==1){
        return intervals;
    }
        List<int[]> res  = new ArrayList<>();
        Arrays.sort(intervals, (int[] it0,int[] it1) -> Integer.compare(it0[0], it1[0]) );
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if(current[1]>=intervals[i][0]){
                int[] temp = new int[2];
                temp[0] = current[0];
                temp[1] = Math.max(current[1], intervals[i][1]);
                current = temp;
            }else{
                res.add(current);
                current = intervals[i];
            }
        }
        res.add(current);
        
        return res.toArray(new int[res.size()][]);
    }
}