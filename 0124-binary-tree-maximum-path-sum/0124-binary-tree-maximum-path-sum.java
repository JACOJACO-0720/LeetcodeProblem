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
        int[] res =  helperFunction(root);
        return Math.max(res[0], res[1]);
    }


    //1 cannot cat 2 can cat
    public int[] helperFunction(TreeNode root){
        if(root.left==null&&root.right==null){
            return new int[]{root.val,root.val};
        }else if(root.left==null){
            int[] tmp =  helperFunction(root.right);
            int cat = Math.max(tmp[1]+root.val, root.val);
            int notcat = tmp[0];
            return new int[]{Math.max(notcat,cat), cat };
        }else if(root.right==null){
            int[] tmp =  helperFunction(root.left);
            int cat = Math.max(tmp[1]+root.val, root.val);
            int notcat = tmp[0];
            return new int[]{Math.max(notcat,cat), cat};
        }else{
            int[] tmpleft =  helperFunction(root.left);
            int[] tmpright =  helperFunction(root.right);
            //not cat
            int leftleft = tmpleft[0];
            int rightright = tmpright[0];
            int leftmidright = tmpleft[1]+ root.val + tmpright[1];
            int notcat = Math.max(leftleft,rightright );
            notcat = Math.max(notcat,leftmidright );
            //cat
            int leftright = tmpleft[1];
            int rightleft = tmpright[1];
            int cat;
            cat = Math.max(leftright+root.val,rightleft+root.val);
            cat = Math.max(cat,root.val);
            return new int[]{Math.max(cat, notcat), cat};
        }
    }
}