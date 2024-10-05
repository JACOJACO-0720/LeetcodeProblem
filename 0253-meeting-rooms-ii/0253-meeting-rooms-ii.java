import java.util.Arrays;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] startTimes = new int[n];
        int[] endTimes = new int[n];
        
        for (int i = 0; i < n; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }
        
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        
        int res = 0, cur = 0;
        int i = 0, j = 0;
        
        while (i < n) {
            if (startTimes[i] < endTimes[j]) {
                cur++;
                i++;
            } else {
                cur--;
                j++;
            }
            res = Math.max(res, cur);
        }
        
        return res;
    }
}
