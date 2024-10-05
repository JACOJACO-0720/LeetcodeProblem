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
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return 0;
        }
        int sum = 0;
        if(root.val == targetSum){
            sum++;
        }
        sum += pathSum(root.left, targetSum);
        sum += pathSum(root.right, targetSum);
        sum += dfs1(root.left, targetSum, targetSum-root.val);
        sum += dfs1(root.right, targetSum, targetSum - root.val);
        return sum;
    }
    long dfs1(TreeNode root, long targetSum, long remain){
        if(root==null){
            return 0;
        }
        long sum = 0;
        if(root.val == remain){
            sum++;
        }
        sum += dfs1(root.left, targetSum ,remain - root.val);
        sum += dfs1(root.right,targetSum ,remain - root.val);
        return sum;
    }

}