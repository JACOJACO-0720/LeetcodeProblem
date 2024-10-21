/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        HashSet<Integer> hs = new HashSet<>();
        for(TreeNode node: nodes){
            hs.add(node.val);
        }
        return helperFunction(root,hs);
    }

    TreeNode helperFunction(TreeNode root, HashSet<Integer> hs){
        if(root==null){
            return null;
        }
        if(hs.contains(root.val)){
            return root;
        }
        TreeNode left = helperFunction(root.left, hs);
        TreeNode right = helperFunction(root.right, hs);
        if(left!=null&&right!=null){
            return root;
        }else if(left==null && right ==null){
            return null;
        }else if(left==null){
            return right;
        }else {
            return left;
        }
    }

}