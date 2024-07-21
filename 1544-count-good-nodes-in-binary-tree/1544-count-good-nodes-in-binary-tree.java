
import java.util.Collection;/**
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
    public int goodNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int count = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(root.val);
        return helperFunction(pq,root.left,count)+helperFunction(pq,root.right,count)+1;

    }
    int helperFunction(PriorityQueue<Integer> pq, TreeNode root,int count){
        if(root==null) return 0;
        int totalNum = 0;
        if(root.val>=pq.peek()){
            totalNum=1;
        }
        pq.add(root.val);
        totalNum = helperFunction(pq,root.left,count)+helperFunction(pq,root.right,count)+totalNum;
        pq.remove(root.val);
        return totalNum;
    }
}