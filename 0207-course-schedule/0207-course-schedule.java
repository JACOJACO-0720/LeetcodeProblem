import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 正向图和入度数组
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        // 初始化邻接表
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // 构建图和入度数组
        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int prerequisite = prereq[1];
            graph.get(prerequisite).add(course); // prerequisite -> course
            inDegree[course]++; // 增加入度
        }

        // 使用队列存储入度为0的节点
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i); // 将所有入度为0的课程放入队列
            }
        }

        // 拓扑排序
        int completedCourses = 0; // 已完成的课程数
        while (!queue.isEmpty()) {
            int course = queue.poll();
            completedCourses++;

            // 遍历邻接课程，减少入度
            for (int nextCourse : graph.get(course)) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse); // 如果某课程的入度为0，加入队列
                }
            }
        }

        // 如果完成的课程数等于总课程数，则可以完成所有课程
        return completedCourses == numCourses;
    }
}
