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
    int ans = 0;
    public int longestZigZag(TreeNode root) {
         maxZigZag(root, 0, 0);
        return ans;
    }

    void maxZigZag(TreeNode root, int left, int count) {
        // NOTE:
        // if left == 0 then its a root node (starting of the traversal)
        // if left == 1 then its a traversal to left node
        // if left == 2 then its a traversal to right node
        if (root == null) {
            return;
        }

        // maximum zig zag is calculated
        ans = Math.max(ans, count);
        
        if (left == 1) {
            // if previous traversal is left than this traversal doesn't counted
            // so the count set to 1 
            maxZigZag(root.left, 1, 1);
        }

        if (left == 0 || left == 2) {
            // if previous traversal is right or its the root node then
            // the count is incremented
            maxZigZag(root.left, 1, count + 1);
        }
        
        if (left == 0 || left == 1) {
            // if previous traversal is left or its the root node then
            // the count is incremented
            maxZigZag(root.right, 2, count + 1);
        }
        if (left == 2) {
            // if previous traversal is right than this traversal doesn't counted
            // so the count set to 1
            maxZigZag(root.right, 2, 1);
        }
    
    }
}