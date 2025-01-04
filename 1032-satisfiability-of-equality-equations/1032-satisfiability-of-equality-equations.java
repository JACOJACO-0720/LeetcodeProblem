import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] ancester = new int[26];
        int[] rank = new int[26];
        HashMap<Integer, HashSet<Integer>> impossible = new HashMap<>();

        // 初始化并查集和秩
        for (int i = 0; i < 26; i++) {
            ancester[i] = i;
            rank[i] = 0;
        }

        // 处理等式
        for (String equation : equations) {
            int left = equation.charAt(0) - 'a';
            int right = equation.charAt(3) - 'a';
            int symbol = equation.charAt(1) == '!' ? 1 : 0;

            if (symbol == 0) { // 等式
                if (!areIncompatible(left, right, ancester, impossible)) {
                    union(left, right, ancester, rank);
                } else {
                    return false; // 冲突
                }
            }
        }

        // 处理不等式
        for (String equation : equations) {
            int left = equation.charAt(0) - 'a';
            int right = equation.charAt(3) - 'a';
            int symbol = equation.charAt(1) == '!' ? 1 : 0;

            if (symbol == 1) { // 不等式
                if (find(left, ancester) == find(right, ancester)) {
                    return false; // 冲突
                }
                // 更新不等关系
                HashSet<Integer> set1 = impossible.getOrDefault(find(left, ancester), new HashSet<>());
                HashSet<Integer> set2 = impossible.getOrDefault(find(right, ancester), new HashSet<>());
                set1.add(find(right, ancester));
                set2.add(find(left, ancester));
                impossible.put(find(left, ancester), set1);
                impossible.put(find(right, ancester), set2);
            }
        }

        return true;
    }

    int find(int origin, int[] ancester) {
        if (ancester[origin] != origin) {
            ancester[origin] = find(ancester[origin], ancester); // 路径压缩
        }
        return ancester[origin];
    }

    void union(int x, int y, int[] ancester, int[] rank) {
        int rootX = find(x, ancester);
        int rootY = find(y, ancester);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                ancester[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                ancester[rootX] = rootY;
            } else {
                ancester[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    private boolean areIncompatible(int x, int y, int[] ancester, HashMap<Integer, HashSet<Integer>> impossible) {
        int rootX = find(x, ancester);
        int rootY = find(y, ancester);
        return impossible.getOrDefault(rootX, new HashSet<>()).contains(rootY);
    }
}
