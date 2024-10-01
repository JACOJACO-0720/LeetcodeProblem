import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length==0){
            int[][] temp =new int[1][2];
            temp[0]=newInterval;
            return temp;
        }
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals,(n1,n2)->(Integer.compare(n1[0], n2[0])));
        int cur = 0;
        while(cur<intervals.length && newInterval[0]>intervals[cur][1]){
            res.add(intervals[cur]);
            cur++;
        }
        if(cur>=intervals.length){
            res.add(newInterval);
             return res.toArray(new int[res.size()][]);
        }
        boolean haschange = false;
        if(cur<intervals.length && newInterval[1]>=intervals[cur][0]){
            haschange=true;
            int[] newarray = new int[2];
            newarray[0] = Math.min(newInterval[0],intervals[cur][0]);
            newarray[1] = Math.max(newInterval[1],intervals[cur][1]);
            cur++;
            if(cur>=intervals.length){
                 res.add(newarray);
                  return res.toArray(new int[res.size()][]);
            }
            while(cur<intervals.length&&intervals[cur][0]<=newarray[1]){
                newarray[0] = Math.min(newarray[0],intervals[cur][0]);
                newarray[1] = Math.max(newarray[1],intervals[cur][1]);
                cur++;
            }
            res.add(newarray);
        }
        if(res.isEmpty()||!haschange){
            res.add(newInterval);
        }
        while(cur<intervals.length && cur<intervals.length){
            res.add(intervals[cur]);
            cur++;
        }
        return res.toArray(new int[res.size()][]);
    }
}