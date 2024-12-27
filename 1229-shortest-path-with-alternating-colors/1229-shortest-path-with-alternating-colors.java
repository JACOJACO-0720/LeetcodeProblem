import java.util.*;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        // 构建红色和蓝色边的邻接表
        List<Integer>[] redAdj = new ArrayList[n];
        List<Integer>[] blueAdj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            redAdj[i] = new ArrayList<>();
            blueAdj[i] = new ArrayList<>();
        }
        for (int[] edge : redEdges) {
            redAdj[edge[0]].add(edge[1]);
        }
        for (int[] edge : blueEdges) {
            blueAdj[edge[0]].add(edge[1]);
        }

        // 距离数组：dist[node][0] 表示红色结束的距离，dist[node][1] 表示蓝色结束的距离
        int[][] dist = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = dist[0][1] = 0;

        // BFS 队列，存储 (node, color)
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0}); // 从红色开始
        queue.offer(new int[]{0, 1}); // 从蓝色开始

        // BFS 遍历
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0], color = curr[1];
            int nextColor = 1 - color; // 交替颜色

            List<Integer>[] adj = (color == 0) ? redAdj : blueAdj;
            for (int neighbor : adj[node]) {
                if (dist[neighbor][nextColor] == Integer.MAX_VALUE) {
                    dist[neighbor][nextColor] = dist[node][color] + 1;
                    queue.offer(new int[]{neighbor, nextColor});
                }
            }
        }

        // 生成结果
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int minDist = Math.min(dist[i][0], dist[i][1]);
            result[i] = (minDist == Integer.MAX_VALUE) ? -1 : minDist;
        }
        return result;
    }
}
