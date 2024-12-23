class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, String> parent = new HashMap<>();
        Map<String, Double> weight = new HashMap<>();

        // 初始化并查集
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            union(parent, weight, a, b, values[i]);
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            if (!parent.containsKey(a) || !parent.containsKey(b) || !find(parent, weight, a).equals(find(parent, weight, b))) {
                result[i] = -1.0;
            } else {
                result[i] = weight.get(a) / weight.get(b);
            }
        }
        return result;
    }

    private void union(Map<String, String> parent, Map<String, Double> weight, String a, String b, double value) {
        if (!parent.containsKey(a)) {
            parent.put(a, a);
            weight.put(a, 1.0);
        }
        if (!parent.containsKey(b)) {
            parent.put(b, b);
            weight.put(b, 1.0);
        }
        String rootA = find(parent, weight, a);
        String rootB = find(parent, weight, b);
        if (!rootA.equals(rootB)) {
            parent.put(rootA, rootB);
            weight.put(rootA, value * weight.get(b) / weight.get(a));
        }
    }

    private String find(Map<String, String> parent, Map<String, Double> weight, String x) {
        if (!x.equals(parent.get(x))) {
            String origin = parent.get(x);
            parent.put(x, find(parent, weight, origin));
            weight.put(x, weight.get(x) * weight.get(origin));
        }
        return parent.get(x);
    }
}
