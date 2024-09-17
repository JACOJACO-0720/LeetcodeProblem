/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helperFunction(nums, 0, mid - 1);
        root.right = helperFunction(nums, mid + 1, nums.length - 1);
        return root;
    }

    TreeNode helperFunction(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(nums[left]);
        } else {
            int mid = left+ (right-left)/2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = helperFunction(nums, left, mid - 1);
            root.right = helperFunction(nums, mid + 1,  right);
            return root;
        }
    }
}