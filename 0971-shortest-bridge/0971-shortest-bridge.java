import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int shortestBridge(int[][] grid) {
        // Step 1: Find the first island and mark it as 2
        outer:
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fillwith2(grid, i, j);
                    break outer;
                }
            }
        }

        // Step 2: Find the border cells of the first island
        List<int[]> firstIslandBorder = findborder(grid, 2, new ArrayList<>());

        // Step 3: BFS from the border cells of the first island to find the second island
        return bfsToFindSecondIsland(grid, firstIslandBorder);
    }

    // DFS to mark the first island as 2
    void fillwith2(int[][] grid, int x, int y) {
        dfs(grid, x, y);
    }

    void dfs(int[][] grid, int x, int y) {
        if (outofbound(grid, x, y) || grid[x][y] == 0 || grid[x][y] == 2) {
            return;
        }
        grid[x][y] = 2; // Mark as part of the first island
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }

    boolean outofbound(int[][] grid, int x, int y) {
        return x < 0 || y < 0 || x >= grid.length || y >= grid[0].length;
    }

    // Find border cells of a specific target island
    List<int[]> findborder(int[][] grid, int target, List<int[]> lst) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == target) {
                    if (isBorder(grid, i, j, target)) {
                        lst.add(new int[]{i, j});
                    }
                }
            }
        }
        return lst;
    }

    boolean isBorder(int[][] grid, int x, int y, int target) {
        // Check if any neighboring cell is not part of the target island
        return (outofbound(grid, x + 1, y) || grid[x + 1][y] != target) ||
               (outofbound(grid, x - 1, y) || grid[x - 1][y] != target) ||
               (outofbound(grid, x, y + 1) || grid[x][y + 1] != target) ||
               (outofbound(grid, x, y - 1) || grid[x][y - 1] != target);
    }

    // BFS to find the shortest distance to the second island
    int bfsToFindSecondIsland(int[][] grid, List<int[]> firstIslandBorder) {
        Queue<int[]> queue = new ArrayDeque<>(firstIslandBorder);
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];

                // Explore neighbors
                for (int[] dir : new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}) {
                    int nx = x + dir[0], ny = y + dir[1];
                    if (!outofbound(grid, nx, ny)) {
                        if (grid[nx][ny] == 1) { // Found the second island
                            return steps;
                        }
                        if (grid[nx][ny] == 0) { // Expand BFS
                            grid[nx][ny] = 2; // Mark as visited
                            queue.add(new int[]{nx, ny});
                        }
                    }
                }
            }
            steps++;
        }

        return -1; // No path found (shouldn't happen in valid input)
    }
}
