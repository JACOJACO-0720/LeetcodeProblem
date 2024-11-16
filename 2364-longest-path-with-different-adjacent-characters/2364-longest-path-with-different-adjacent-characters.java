class Solution {
    int ans = 0;
    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        List<Integer>[] subtrees = newArray(n);

        for(int i = 1; i < n; i++) {
            subtrees[parent[i]].add(i);
        }

        dfs(0, -1, subtrees, s);

        return ans;
    }

    private int dfs(int node, int parent, List<Integer>[] subtrees, String s) {
        int max = 0;

        for(int child: subtrees[node]) {
            int part = dfs(child, node, subtrees, s);
            ans = Math.max(ans, part + max + 1);
            max = Math.max(max, part);
        }

        max += 1;

        if (max > ans) {
            ans = max;
        }

        if (parent != -1 && s.charAt(parent) == s.charAt(node)) {
            return 0;
        }

        return max;
    }

    private List<Integer>[] newArray(int n) {
        ArrayList<Integer>[] ans = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            ans[i] = new ArrayList<>();
        }
        return ans;
    }
}