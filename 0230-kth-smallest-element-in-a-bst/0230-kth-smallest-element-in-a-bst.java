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
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        
        int result = helperFunction(root.left, k);
        if(result!=-1){
            return result;
        }
        count++;
        if(count==k){
            return root.val;
        }
        return helperFunction(root.right,k);
    }
    int helperFunction(TreeNode root, int k){
        if(root==null){
            return -1;
        }else{
            int result =  helperFunction(root.left, k);
            if(result!=-1){
                return result;
            }
            count++;
            if(count==k){
                return root.val;
            }
            return helperFunction(root.right,k);
        }
    }
    
}