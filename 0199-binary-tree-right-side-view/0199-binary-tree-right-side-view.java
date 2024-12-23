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
     int maxHeight = 0;
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            List<Integer> lst = new ArrayList<>();
            return lst;
        }

        int[] map = new int[100];
        Arrays.fill(map, -101);
       
        int curHeight = 0;
        dfs(root, map, 0);
        List<Integer> res=  new ArrayList<>();
        for (int i = 1; i < map.length; i++) {
            if(map[i]==-101){
                break;
            }else{
                res.add(map[i]);
            }
        }
        return res;

    }
    void dfs(TreeNode root, int[] map, int curHeight){
        if(root == null){
            return;
        }
        curHeight++;
        maxHeight = Math.max(maxHeight, curHeight);

        if(map[curHeight]==-101){
            map[curHeight] = root.val;
        }
        dfs(root.right, map, curHeight);
        dfs(root.left, map, curHeight);

    }

}