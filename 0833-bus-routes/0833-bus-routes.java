import java.util.*;

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }

        // 标记公交线路是否被访问过
        boolean[] visitedBuses = new boolean[routes.length];

        // 使用一个邻接表，记录每个站点对应的公交线路
        List<List<Integer>> lst = new ArrayList<>(100000);
        for (int i = 0; i < 100000; i++) {
            lst.add(new ArrayList<>());  // 每个站点添加一个新的 ArrayList 存储经过该站点的公交线路
        }

        // 填充邻接表，建立每个站点到公交线路的映射
        for (int i = 0; i < routes.length; i++) {
            int[] route = routes[i];
            for (int stop : route) {
                lst.get(stop).add(i);
            }
        }

        // 如果源站没有公交经过，直接返回 -1
        if (lst.get(source).isEmpty()) {
            return -1;
        }

        // 初始化 BFS 队列，并且将源站经过的所有公交线路加入队列
        ArrayDeque<Integer> ad = new ArrayDeque<>(); // Integer 表示公交线路编号
        for (int bus : lst.get(source)) {
            ad.add(bus);
        }

        // 标记公交站点是否被访问过，避免重复搜索
        boolean[] visitedStops = new boolean[100000];
        visitedStops[source] = true;

        int result = 1; // 表示所乘坐的公交车次数

        while (!ad.isEmpty()) {
            int size = ad.size();
            for (int i = 0; i < size; i++) {
                int currentBus = ad.poll(); // 取出当前公交线路编号

                // 如果该公交线路已经被访问，跳过
                if (visitedBuses[currentBus]) {
                    continue;
                }

                // 将当前公交线路标记为访问过
                visitedBuses[currentBus] = true;

                // 遍历当前公交线路上的所有站点
                for (int stop : routes[currentBus]) {
                    // 如果找到目标站点，返回结果
                    if (stop == target) {
                        return result;
                    }

                    // 如果该站点还没有访问过，访问该站点的所有公交线路
                    if (!visitedStops[stop]) {
                        visitedStops[stop] = true;
                        for (int nextBus : lst.get(stop)) {
                            if (!visitedBuses[nextBus]) {
                                ad.add(nextBus); // 将未访问的公交线路加入队列
                            }
                        }
                    }
                }
            }
            result++;
        }

        // 如果遍历完所有线路仍未找到目标站点，返回 -1
        return -1;
    }
}
