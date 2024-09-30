import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n==1){
            return true;
        }
        if(n-1>edges.length){
            return false;
        }
        boolean[] visited = new boolean[n];
        List<List<Integer>> lst = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> tmp = new ArrayList<>();
            lst.add(tmp);
        }
        for(int[] t: edges){
            lst.get(t[0]).add(t[1]);
            lst.get(t[1]).add(t[0]);
        }

        for (int i = 0; i < lst.size(); i++) {
            if(lst.get(i).isEmpty()){
                return false;
            }
        }
        int cur = 0;
        boolean res =  dfs(cur, visited, -1, lst);
        for (int i = 0; i < visited.length; i++) {
            if(visited[i]==false){
                return false;
            }
        }
        return res;
    }
    boolean dfs(int cur, boolean[] visited, int last, List<List<Integer>> lst){
        if(visited[cur]){
            return false;
        }
        visited[cur] = true;
        List<Integer> tmplst = lst.get(cur);
        for (int i = 0; i < tmplst.size(); i++) {
            int tmp = tmplst.get(i);
            if(tmp==last){
                continue;
            }else{
                boolean tmpres = dfs(tmp, visited, cur, lst);
                if(tmpres==false){
                    return false;
                }
            }
        }
        return true;
    }
}