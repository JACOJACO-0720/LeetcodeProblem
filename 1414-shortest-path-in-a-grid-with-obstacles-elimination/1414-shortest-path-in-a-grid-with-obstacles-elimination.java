import java.util.ArrayDeque;

class Solution {
    public int shortestPath(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][][] visited = new int[rows][cols][2];

        ArrayDeque<Node> ad = new ArrayDeque<>();
        ad.add(new Node(0, 0, 0));
        int res = 0;

        // 定义四个方向：上(-1, 0)，下(1, 0)，左(0, -1)，右(0, 1)
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!ad.isEmpty()) {
            int size = ad.size();
            for (int i = 0; i < size; i++) {
                Node temp = ad.poll();
                int x = temp.x;
                int y = temp.y;
                int n = temp.numOfBreak;

                // 如果到达终点，返回结果
                if (x == rows - 1 && y == cols - 1) {
                    return res;
                }

                // 遍历四个方向
                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if (!outofbound(newX, newY, grid)) {
                        continue;
                    }

                    if (visited[newX][newY][0] == 0) {
                        if (grid[newX][newY] == 0) {
                            visited[newX][newY][1] = n;
                            visited[newX][newY][0] = res + 1;
                            ad.add(new Node(newX, newY, n));
                        } else {
                            if (n == k) {
                                continue;
                            } else {
                                visited[newX][newY][1] = n + 1;
                                ad.add(new Node(newX, newY, n + 1));
                                visited[newX][newY][0] = res + 1;
                            }
                        }
                    } else {
                        if (grid[newX][newY] == 0) {
                            int oldn = visited[newX][newY][1];
                            if (oldn <= n) {
                                continue;
                            } else {
                                visited[newX][newY][1] = n;
                                ad.add(new Node(newX, newY, n));
                            }
                        } else {
                            if (n == k) {
                                continue;
                            } else {
                                int oldn = visited[newX][newY][1];
                                if (oldn <= n+1) {
                                    continue;
                                } else {
                                    visited[newX][newY][1] = n + 1;
                                    ad.add(new Node(newX, newY, n + 1));
                                }
                            }
                        }

                    }
                }
            }
            res++;
        }

        return -1; // 如果没有路径，返回 -1
    }

    // 边界检查函数
    boolean outofbound(int x, int y, int[][] grid) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }

    // Node 类
    class Node {
        int x;
        int y;
        int numOfBreak;

        public Node(int x, int y, int numOfBreak) {
            this.x = x;
            this.y = y;
            this.numOfBreak = numOfBreak;
        }
    }
}
