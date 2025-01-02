import java.util.ArrayDeque;

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int res = 0;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(entrance);

        // 标记入口为已访问，避免误判和重复处理
        maze[entrance[0]][entrance[1]] = '+';

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] tmp = queue.poll();
                int x = tmp[0], y = tmp[1];

                // 检查是否为出口，且不是入口
                if (isboarder(maze, x, y) && !(x == entrance[0] && y == entrance[1])) {
                    return res;
                }

                // 将相邻节点加入队列，并标记为已访问
                if (!outofbounds(maze, x + 1, y) && maze[x + 1][y] == '.') {
                    maze[x + 1][y] = '+'; // 标记访问
                    queue.add(new int[]{x + 1, y});
                }
                if (!outofbounds(maze, x - 1, y) && maze[x - 1][y] == '.') {
                    maze[x - 1][y] = '+'; // 标记访问
                    queue.add(new int[]{x - 1, y});
                }
                if (!outofbounds(maze, x, y + 1) && maze[x][y + 1] == '.') {
                    maze[x][y + 1] = '+'; // 标记访问
                    queue.add(new int[]{x, y + 1});
                }
                if (!outofbounds(maze, x, y - 1) && maze[x][y - 1] == '.') {
                    maze[x][y - 1] = '+'; // 标记访问
                    queue.add(new int[]{x, y - 1});
                }
            }
            res++;
        }
        return -1; // 无法找到出口
    }

    boolean isboarder(char[][] maze, int x, int y) {
        return x == 0 || y == 0 || x == maze.length - 1 || y == maze[0].length - 1;
    }

    boolean outofbounds(char[][] maze, int x, int y) {
        return x < 0 || y < 0 || x >= maze.length || y >= maze[0].length;
    }
}
