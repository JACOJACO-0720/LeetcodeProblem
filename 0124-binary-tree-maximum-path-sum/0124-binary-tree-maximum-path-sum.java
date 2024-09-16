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
    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        int[] res= dfs(root);
        return Math.max(res[0],res[1]);
    }

    int[] dfs(TreeNode root){
        if(root==null){
            int[] temp = new int[2];
            temp[0] = -1000;
            temp[1] = -1000;
            return temp;
        }else{
            //for global
            int[] left = dfs(root.left);
            int[] right = dfs(root.right);
            //for local
            int global = Math.max(root.val, Math.max(root.val+left[0], root.val+right[0]));
            int local = Math.max(Math.max(global, root.val+left[0]+right[0]), Math.max(right[1], left[1]));
            int[] res = new int[2];
            res[0] = global;
            res[1] = local;
            return res;
        }
    }
}