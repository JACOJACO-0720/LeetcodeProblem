import java.util.ArrayList;

class Solution {
    public int minimumMoves(int[][] grid) {
        ArrayList<int[]> alhas = new ArrayList<>();
        ArrayList<int[]> alempty = new ArrayList<>();
        // 收集多余元素的位置和空位的位置
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int temp = grid[i][j];
                if (temp == 0) {
                    int[] tmplst = {i, j};
                    alempty.add(tmplst);
                } else if (temp == 1) {
                    continue;
                } else {
                    while (temp > 1) {
                        temp--;
                        int[] tmplst = {i, j};
                        alhas.add(tmplst);
                    }
                }
            }
        }

        // 使用暴力搜索所有可能的匹配方式
        boolean[] used = new boolean[alempty.size()];
        return dfs(alhas, alempty, used, 0, 0, Integer.MAX_VALUE);
    }

    private int dfs(ArrayList<int[]> alhas, ArrayList<int[]> alempty, boolean[] used, int index, int currentCost, int minCost) {
        if (currentCost >= minCost) {
            // 剪枝：如果当前成本已经超过最小成本，直接返回
            return minCost;
        }
        if (index == alhas.size()) {
            // 所有多余元素都已分配，更新最小成本
            return Math.min(minCost, currentCost);
        }
        // 尝试将当前的多余元素分配给每一个未使用的空位
        for (int i = 0; i < alempty.size(); i++) {
            if (!used[i]) {
                used[i] = true;
                int[] hasPos = alhas.get(index);
                int[] emptyPos = alempty.get(i);
                int cost = Math.abs(hasPos[0] - emptyPos[0]) + Math.abs(hasPos[1] - emptyPos[1]);
                minCost = dfs(alhas, alempty, used, index + 1, currentCost + cost, minCost);
                used[i] = false;
            }
        }
        return minCost;
    }
}
