import java.util.ArrayList;

class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            al.add(i);
        }

        // 预计算阶乘
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        StringBuilder sb = new StringBuilder();
        dfs(al, sb, factorial, n, k);
        return sb.toString();
    }

    void dfs(ArrayList<Integer> al, StringBuilder sb, int[] factorial, int n, int k) {
        if (al.size() == 1) {
            sb.append(al.get(0));
            return;
        }

        int interval = factorial[n - 1];
        int seq = (k - 1) / interval; // 计算当前数字的索引
        sb.append(al.get(seq));
        al.remove(seq); // 移除已使用的数字

        int nextK = k % interval == 0 ? interval : k % interval; // 修正 k 的更新逻辑
        dfs(al, sb, factorial, n - 1, nextK);
    }
}
