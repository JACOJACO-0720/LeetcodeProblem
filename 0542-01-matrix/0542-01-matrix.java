import java.util.ArrayDeque;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;

        // Initialize BFS queue
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        // Initialize result matrix with a large value for non-zero cells
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j}); // Add all 0s to the queue
                } else {
                    result[i][j] = Integer.MAX_VALUE; // Mark as unvisited
                }
            }
        }

        // BFS to calculate distances
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];

            for (int[] dir : directions) {
                int nx = x + dir[0], ny = y + dir[1];

                // Check bounds and whether this cell can be updated
                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    if (result[nx][ny] > result[x][y] + 1) {
                        result[nx][ny] = result[x][y] + 1; // Update distance
                        queue.add(new int[]{nx, ny}); // Add to queue for further expansion
                    }
                }
            }
        }

        return result;
    }
}
