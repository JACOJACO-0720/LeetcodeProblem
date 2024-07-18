import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        //[[1],[3,2],[4,5]]
        if(root ==null){
            return new ArrayList<>();
        }
        ArrayDeque<TreeNode> ad = new ArrayDeque<>();
        ad.add(root);
        int level = 0;
        while(!ad.isEmpty()){
            List<Integer> tempList = new ArrayList<>();
            int csize = ad.size();
            level++;
            for (int i = 0; i <csize ; i++) {
                TreeNode temp = ad.pollFirst();
                    tempList.add(temp.val);
                
                    if(temp.left!=null){
                        ad.add(temp.left);

                    }
                    if(temp.right!=null){
                        ad.add(temp.right);
                    }
            }
            if(level%2==0){
                tempList=tempList.reversed();
            }
            res.add(tempList);
        }
        return res;
    
    }
    // public class TreeNode {
    //     int val;
    //     TreeNode left;
    //     TreeNode right;
    //     TreeNode() {}
    //     TreeNode(int val) { this.val = val; }
    //     TreeNode(int val, TreeNode left, TreeNode right) {
    //         this.val = val;
    //         this.left = left;
    //         this.right = right;
    //     }
    // }
}