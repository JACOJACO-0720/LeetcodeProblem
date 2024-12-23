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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i =0;i< inorder.length; i++){
            hm.put(inorder[i], i);
        }

        TreeNode root = new TreeNode(preorder[0]);
        int mid = hm.get(preorder[0]);
        root.left = helperFunction(preorder, inorder, hm, 0, mid-1, 1, mid-0);
        root.right = helperFunction(preorder, inorder, hm, mid+1, inorder.length-1, mid+1, preorder.length-1);
        return root;
    }

    TreeNode helperFunction(int[] preorder, int[] inorder, HashMap<Integer, Integer> hm, int left, int right, int l, int r){
        if(left>right){
            return null;
        }else if(left==right){
            TreeNode newt = new TreeNode(preorder[l]);
            return newt;
        }else{
            TreeNode root = new TreeNode(preorder[l]);
            int mid = hm.get(preorder[l]);
            root.left = helperFunction(preorder, inorder, hm, left, mid-1, l+1, l+1+(mid-left-1));
            root.right = helperFunction(preorder, inorder, hm, mid+1, right, l+1+(mid-left), r);
            return root;
        }
    }
}