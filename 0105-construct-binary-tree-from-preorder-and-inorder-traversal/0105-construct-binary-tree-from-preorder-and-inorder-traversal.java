class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        // 将中序遍历的值和索引存入哈希表
        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }
        // 调用递归函数构建树
        return helperFunction(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, hm);
    }

    // 递归辅助函数
    TreeNode helperFunction(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> hm) {
        if (preStart > preEnd || inStart > inEnd) {
            return null; // 基础情况
        }

        // 根节点是前序遍历的第一个元素
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // 找到根节点在中序遍历中的索引
        int rootIndex = hm.get(rootVal);

        // 计算左子树的大小
        int leftSize = rootIndex - inStart;

        // 递归构建左子树
        root.left = helperFunction(preorder, preStart + 1, preStart + leftSize, inorder, inStart, rootIndex - 1, hm);

        // 递归构建右子树
        root.right = helperFunction(preorder, preStart + leftSize + 1, preEnd, inorder, rootIndex + 1, inEnd, hm);

        return root;
    }
}
