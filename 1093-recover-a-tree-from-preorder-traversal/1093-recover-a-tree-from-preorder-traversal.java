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
    public TreeNode recoverFromPreorder(String traversal) {
        if(traversal.length()==1){
            return new TreeNode(Integer.valueOf(traversal));
        }
        int right = 0;
        while(traversal.charAt(right)>='0' && traversal.charAt(right)<='9'){
            right++;
        }
        int rootval = Integer.valueOf(traversal.substring(0,right));
        TreeNode root = new TreeNode(rootval);
        helperFunction(root, right, traversal,1);
        return root;


    }
    int helperFunction(TreeNode root, int cur, String traversal, int deep){
        if(cur > traversal.length()){
            return cur;
        }
        int left = cur;
        int right = cur;
        while(right<traversal.length() &&(traversal.charAt(right)<'0' || traversal.charAt(right)>'9')){
            right++;
        }
        int tempdeep = right-left;
        if(tempdeep == deep){
            left=right;
            while(right<traversal.length() && traversal.charAt(right)>='0' && traversal.charAt(right)<='9'){
                right++;
            }
            int rootval = Integer.valueOf(traversal.substring(left,right));
            root.left = new TreeNode(rootval);
            right = helperFunction(root.left, right, traversal,deep+1);
            left = right;
                while(right<traversal.length() &&(traversal.charAt(right)<'0' || traversal.charAt(right)>'9')){
                    right++;
                }
                tempdeep = right-left;
                    if(tempdeep == deep){
                        left=right;
                        while(right<traversal.length()&&traversal.charAt(right)>='0' && traversal.charAt(right)<='9'){
                            right++;
                        }
                        rootval = Integer.valueOf(traversal.substring(left,right));
                        root.right = new TreeNode(rootval);
                        right = helperFunction(root.right, right, traversal,deep+1);
                         left = right;
                    }
        }

        return left;
    }

}