class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] state = new int[n]; // 0: 未访问, 1: 正在访问, 2: 安全
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (isSafe(graph, state, i)) {
                res.add(i);
            }
        }

        Collections.sort(res);
        return res;
    }

    // 判断当前节点是否是安全节点
    private boolean isSafe(int[][] graph, int[] state, int cur) {
        if (state[cur] > 0) {
            return state[cur] == 2; // 如果是安全的返回 true，否则返回 false
        }

        state[cur] = 1; // 标记为正在访问
        for (int next : graph[cur]) {
            if (!isSafe(graph, state, next)) {
                state[cur] = 1; // 检测到环或不安全路径
                return false;
            }
        }

        state[cur] = 2; // 标记为安全节点
        return true;
    }
}
