import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] map = new int[m][n];
        List<Integer> res = new ArrayList<>();
        int num = 0;

        HashMap<String, String> hm = new HashMap<>(); // 用于存储每个格子的父节点
        for (int[] pos : positions) {
            int x = pos[0];
            int y = pos[1];

            // 如果该位置已经是陆地，跳过
            if (map[x][y] == 1) {
                res.add(num);
                continue;
            }

            // 将当前位置设为陆地并更新并查集
            String key = x + "-" + y;
            hm.put(key, key);
            map[x][y] = 1;
            num++; // 初始新增一个岛屿

            // 遍历四个方向，如果邻居是陆地，进行合并
            for (int[] dir : new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (!outofbound(map, nx, ny) && map[nx][ny] == 1) {
                    String neighborKey = nx + "-" + ny;
                    if (!findAncestor(hm, key).equals(findAncestor(hm, neighborKey))) {
                        union(hm, key, neighborKey);
                        num--; // 合并岛屿后总数减少
                    }
                }
            }

            res.add(num);
        }
        return res;
    }

    // 合并两个节点
    void union(HashMap<String, String> hm, String key1, String key2) {
        String ancestor1 = findAncestor(hm, key1);
        String ancestor2 = findAncestor(hm, key2);
        if (!ancestor1.equals(ancestor2)) {
            hm.put(ancestor1, ancestor2); // 将一个节点的祖先指向另一个节点的祖先
        }
    }

    // 查找节点的祖先
    String findAncestor(HashMap<String, String> hm, String key) {
        if (hm.get(key).equals(key)) {
            return key;
        } else {
            String ancestor = findAncestor(hm, hm.get(key));
            hm.put(key, ancestor); // 路径压缩
            return ancestor;
        }
    }

    // 检查是否越界
    boolean outofbound(int[][] map, int x, int y) {
        return x < 0 || y < 0 || x >= map.length || y >= map[0].length;
    }
}
