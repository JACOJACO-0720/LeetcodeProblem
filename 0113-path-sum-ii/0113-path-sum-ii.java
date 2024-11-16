/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        helperFunction(root, targetSum, new ArrayList<>(), res);
        return res;
    }
    
    private void helperFunction(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        
        // Add current node value to the path
        path.add(root.val);
        
        // Check if this is a leaf node and the path sum matches targetSum
        if (root.left == null && root.right == null && targetSum == root.val) {
            res.add(new ArrayList<>(path)); // Add a copy of the current path
        }
        
        // Continue the recursion for left and right subtree
        helperFunction(root.left, targetSum - root.val, path, res);
        helperFunction(root.right, targetSum - root.val, path, res);
        
        // Backtrack: remove the current node from the path
        path.remove(path.size() - 1);
    }
}
