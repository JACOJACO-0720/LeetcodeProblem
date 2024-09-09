import java.util.*;

class Solution {

    private Map<Integer, Integer> dp;

    public int mincostTickets(int[] days, int[] costs) {
        dp = new HashMap<>();
        return dfs(0, days, costs);
    }

    // DFS Helper function (now as a separate method)
    private int dfs(int i, int[] days, int[] costs) {
        if (i == days.length) {
            return 0;
        }

        if (dp.containsKey(i)) {
            return dp.get(i);
        }

        int minCost = Integer.MAX_VALUE;
        int j = i;
        int[] durations = {1, 7, 30};  // ticket durations

        // Try all ticket types: 1-day, 7-day, 30-day
        for (int k = 0; k < 3; k++) {
            while (j < days.length && days[j] < days[i] + durations[k]) {
                j++;
            }
            minCost = Math.min(minCost, costs[k] + dfs(j, days, costs));
        }

        dp.put(i, minCost);  // Memoize the result
        return minCost;
    }
}
