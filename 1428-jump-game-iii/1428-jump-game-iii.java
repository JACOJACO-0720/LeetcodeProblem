class Solution {
        int numOfZero = 0;
    public boolean canReach(int[] arr, int start) {
        //prune 
        
        for(int a: arr){
            if(a == 0){
                numOfZero++;
            }
        }
        boolean[] visited = new boolean[arr.length];
     return dfs(visited, start, arr);

    }
    boolean dfs(boolean[] visited, int cur, int[] arr){
        if(visited[cur]){
            return false;
        }else{
            visited[cur] = true;
            if(arr[cur]==0){
                return true;
            }else{
                boolean one =false;
                boolean two =false;
                if(cur + arr[cur]<arr.length){
                    one = dfs(visited, cur + arr[cur], arr);
                }
                if(cur - arr[cur]>=0){
                    two = dfs(visited, cur - arr[cur], arr);
                }
                 return one || two;
            }
          
        }
    }
}