import java.util.ArrayList;

class Solution {
    int res = 0;

    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return res;
    }

    private ArrayList<Integer> dfs(TreeNode root, int distance) {
        // 处理空节点
        if (root == null) {
            return new ArrayList<>();
        }

        // 如果是叶节点，返回到自身距离为1
        if (root.left == null && root.right == null) {
            ArrayList<Integer> leafDistances = new ArrayList<>();
            leafDistances.add(1);
            return leafDistances;
        }

        // 递归计算左右子树的叶节点距离
        ArrayList<Integer> leftDistances = dfs(root.left, distance);
        ArrayList<Integer> rightDistances = dfs(root.right, distance);

        // 遍历左右子树叶节点距离，计算满足条件的叶节点对
        for (int leftDist : leftDistances) {
            for (int rightDist : rightDistances) {
                if (leftDist + rightDist <= distance) {
                    res++;
                }
            }
        }

        // 更新当前节点的叶节点距离，加1后返回给父节点
        ArrayList<Integer> currentDistances = new ArrayList<>();
        for (int d : leftDistances) {
            if (d + 1 < distance) { // 剪枝，超过distance的不再考虑
                currentDistances.add(d + 1);
            }
        }
        for (int d : rightDistances) {
            if (d + 1 < distance) {
                currentDistances.add(d + 1);
            }
        }

        return currentDistances;
    }
}
