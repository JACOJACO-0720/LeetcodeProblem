class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i =0;i<n;i++){
            List<Integer> newlst = new ArrayList<Integer>();
            adjList.add(newlst);
        }
        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        int res = 0 ;
        for(int i =0 ;i<n;i++){
            if(!visited[i]){
                res++;
                dfs(visited, i, adjList );
            }
        }

        return res;


    }
    void dfs(boolean[] visited, int n ,List<List<Integer>> adjList){
            if(visited[n]){
                return;
            }
            visited[n] = true;

            List<Integer> lst = adjList.get(n);
            for (int i = 0; i < lst.size(); i++) {
                dfs(visited, lst.get(i), adjList );
            }
        }
}