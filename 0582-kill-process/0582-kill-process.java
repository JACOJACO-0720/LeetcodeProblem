class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            List<Integer> lst = adjList.getOrDefault(ppid.get(i), new ArrayList<>());
             lst.add(pid.get(i));
             adjList.put(ppid.get(i),lst );
        }
        List<Integer> res = new ArrayList<>();
        dfs(res, kill,adjList);
        return res;
    }
    void dfs(List<Integer> res, int kill, HashMap<Integer, List<Integer>> adjList){
        List<Integer> child = adjList.get(kill);
        res.add(kill);
        if(child==null){
            return;
        }
        for (int i = 0; i < child.size(); i++) {
            dfs(res, child.get(i),adjList);
        }
    }
}