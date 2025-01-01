class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int max = 0;
        for(int i=0; i<n; i++){
            if(manager[i] != -1) {
                max = Math.max(max, dfs(manager, informTime, i));
            }
        }
        return max;
    }
    public int dfs(int[] manager, int[] informTime, int currentEmp){
        if(manager[currentEmp] == -1) return informTime[currentEmp];
        informTime[currentEmp] += dfs(manager, informTime, manager[currentEmp]);
        manager[currentEmp] = -1;
        return informTime[currentEmp];
    }
}