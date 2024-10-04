import java.util.ArrayList;
import java.util.List;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] computed = new boolean[isConnected.length];
        List<Integer>[] adjList = new ArrayList[isConnected.length];
        for (int i = 0; i < adjList.length; i++) {
            List<Integer> temp = new ArrayList<>();
            adjList[i] = temp; 
        }
        
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if(i==j){
                    continue;
                }else{
                    if(isConnected[i][j]==1){
                        adjList[i].add(j);
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < computed.length; i++) {
            
            if(!computed[i]){
                count++;
                dfs(computed, adjList, i);
            }
        }
        return count;
    }
    void dfs(boolean[] computed, List<Integer>[] adjList, int cur){
        if(computed[cur]){
            return;
        }else{
            computed[cur] = true;
            List<Integer> tmplst = adjList[cur];
            for (int i = 0; i < tmplst.size(); i++) {
                dfs(computed, adjList, tmplst.get(i));
            }
        }
    }
    
    
}