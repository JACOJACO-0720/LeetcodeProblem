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
        HashMap<TreeNode, Integer> falseMap = new HashMap<>(); 
        HashMap<TreeNode, Integer> trueMap = new HashMap<>(); 
    public int minimumFlips(TreeNode root, boolean result) {
        if(root.val<2) {
                int temp = 0;
                if (result == true) {
                    temp = 1;
                }
                if (temp != root.val) {
                    return 1;
                } else {
                    return 0;
                }
        }

        int leftFalse = -1;
        int leftTrue = -1;
        int rightFlase = -1;
        int rightTrue = -1;
        if(root.right!=null){
            if(falseMap.containsKey(root.right)){
                rightFlase = falseMap.get(root.right);
            }else{
                rightFlase = minimumFlips(root.right, false);
                falseMap.put(root.right, rightFlase);
            }
            if(trueMap.containsKey(root.right)){
                rightTrue = trueMap.get(root.right);
            }else{
                rightTrue = minimumFlips(root.right, true);
                trueMap.put(root.right, rightTrue);
            }

        }
        if(root.left!=null){
            if(falseMap.containsKey(root.left)){
                leftFalse = falseMap.get(root.left);
            }else{
               leftFalse = minimumFlips(root.left, false);
               falseMap.put(root.left, leftFalse);
            }
            if(trueMap.containsKey(root.left)){
                leftTrue = trueMap.get(root.left);
            }else{
                leftTrue = minimumFlips(root.left, true);
                trueMap.put(root.left, leftTrue);
            }
        }

        switch (root.val) {
            case 2: {
                if (result == true) {
                    
                    int zeroOne = leftFalse + rightTrue;
                    int oneZero = leftTrue + rightFlase;
                    int oneOne = leftTrue + rightTrue;
                    int res = Math.min(zeroOne, oneZero);
                    res = Math.min(res, oneOne);
                    return res;
                } else {
                    return leftFalse + rightFlase;
                }
            }
            case 3: {
                if (result == true) {
                    return leftTrue + rightTrue;
                } else {
                    int zeroOne = leftFalse + rightTrue;
                    int oneZero = leftTrue + rightFlase;
                    int zeroZero = leftFalse + rightFlase;
                    int res = Math.min(zeroOne, oneZero);
                    res = Math.min(res, zeroZero);
                    return res;
                }
            }
            case 4: {
                if (result == true) {
                    int oneZero = leftTrue + rightFlase;
                    int zeroOne = leftFalse + rightTrue;
                    int res = Math.min(oneZero, zeroOne);
                    return res;
                } else {
                    int oneOne = leftTrue + rightTrue;
                    int zeroZero = leftFalse + rightFlase;
                    int res = Math.min(oneOne, zeroZero);
                    return res;
                }
            }
            case 5: {
                if (result == true) {
                    if (root.left == null) {
                        return rightFlase;
                    } else {
                        return leftFalse;
                    }
                } else {
                    if (root.left == null) {
                        return rightTrue;
                    } else {
                        return leftTrue;
                    }
                }
            }
            default:{
                return 0;
            }
        }
    }
}