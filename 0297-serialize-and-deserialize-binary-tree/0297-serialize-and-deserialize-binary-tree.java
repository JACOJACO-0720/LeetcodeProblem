/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helperFunction(root, sb);
        return sb.toString();
    }

    void helperFunction(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append("1001");
            sb.append(",");
            return;
        }else{
            sb.append(root.val);
            sb.append(",");
            helperFunction(root.left, sb);
            helperFunction(root.right, sb);
            return; 
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strlist = data.split(",");
        int[] index = {0};
        TreeNode root = helperFunction1(strlist, index);
        return root;
    }

    TreeNode helperFunction1(String[] strlist, int[] index){
        
        String temp = strlist[index[0]];

        if(temp.equals("1001")||temp.equals("")){
            index[0]++;
            return null;
        }else{
            TreeNode root = new TreeNode(Integer.valueOf(temp));
            index[0]++;
            root.left = helperFunction1(strlist, index);
            root.right = helperFunction1(strlist, index);
            return root;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));