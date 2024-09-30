import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        TreeNode root = new TreeNode();
        for(String word: wordDict){
            TreeNode cur = root;
            for(int i =0;i<word.length();i++){
                if(cur.list[word.charAt(i) -'a']==null){
                    cur.list[word.charAt(i) -'a'] = new TreeNode();
                }
                cur = cur.list[word.charAt(i)-'a'];
            }
            cur.isend = true;
        }

        List<ArrayList<Integer>> dp = new ArrayList<>(s.length() + 1);
        for (int i = 0; i <= s.length(); i++) {
            dp.add(new ArrayList<>());
        }

        List<String> res = new ArrayList<>();


        ArrayList<String> temp = new ArrayList<>();
        dfs(s, dp, res, 0, temp,root);
        return res;
    }
    void dfs(String s, List<ArrayList<Integer>> dp, List<String> res, int cur, ArrayList<String> temp, TreeNode root){
        if(cur == s.length()){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < temp.size(); i++) {
                sb.append(temp.get(i)).append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            res.add(sb.toString());
            return ;
        }
        if(!dp.get(cur).isEmpty()){
            List<Integer> tmplst = dp.get(cur);
            for (int i = 0; i < tmplst.size(); i++) {
                temp.add(s.substring(cur, tmplst.get(i)+1));
                dfs(s, dp, res, tmplst.get(i)+1, temp,root);
                temp.remove(temp.size()-1);
            }
            return;
        }
        int tempcur = cur;
        TreeNode curNode = root;
        ArrayList<Integer> tempdp = new ArrayList<>();
        while(tempcur < s.length()){
            if(curNode.list[s.charAt(tempcur)-'a']==null){
                dp.set(cur,tempdp);
                return;
            }else{
                curNode = curNode.list[s.charAt(tempcur)-'a'];
                if(curNode.isend){
                    tempdp.add(tempcur);
                    temp.add(s.substring(cur, tempcur+1));
                    dfs(s, dp, res, tempcur+1,  temp, root);
                    temp.remove(temp.size()-1);

                }
                tempcur++;
            }
        }
        dp.set(cur,tempdp);
        return;
    }

    class TreeNode{
        TreeNode[] list = new TreeNode[26];
        boolean isend = false;
    }
}