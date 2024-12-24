import java.util.*;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 并查集的 parent 和 weight
        Map<String, String> parent = new HashMap<>();
        Map<String, Double> weight = new HashMap<>();

        // 构建并查集
        for (int i = 0; i < equations.size(); i++) {
            String var1 = equations.get(i).get(0);
            String var2 = equations.get(i).get(1);
            double value = values[i];
            union(parent, weight, var1, var2, value);
        }

        // 处理查询
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);

            if (!parent.containsKey(var1) || !parent.containsKey(var2)) {
                result[i] = -1.0; // 不在同一个连通分量
            } else {
                String root1 = find(parent, weight, var1);
                String root2 = find(parent, weight, var2);
                if (!root1.equals(root2)) {
                    result[i] = -1.0; // 不在同一个连通分量
                } else {
                    result[i] = weight.get(var1) / weight.get(var2); // 计算比值
                }
            }
        }

        return result;
    }

    // 并查集的合并操作
    private void union(Map<String, String> parent, Map<String, Double> weight, String var1, String var2, double value) {
        if (!parent.containsKey(var1)) {
            parent.put(var1, var1);
            weight.put(var1, 1.0);
        }
        if (!parent.containsKey(var2)) {
            parent.put(var2, var2);
            weight.put(var2, 1.0);
        }

        String root1 = find(parent, weight, var1);
        String root2 = find(parent, weight, var2);

        if (!root1.equals(root2)) {
            parent.put(root1, root2);
            weight.put(root1, value * weight.get(var2) / weight.get(var1));
        }
    }

    // 并查集的查找操作（带路径压缩）
    private String find(Map<String, String> parent, Map<String, Double> weight, String var) {
        if (!var.equals(parent.get(var))) {
            String origin = parent.get(var);
            parent.put(var, find(parent, weight, origin));
            weight.put(var, weight.get(var) * weight.get(origin)); // 更新比值
        }
        return parent.get(var);
    }
}
