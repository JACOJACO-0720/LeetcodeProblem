class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        List<List<Integer>> lst = new ArrayList<>();
        int[] degree = new int[n+1];
        for(int i =0;i< n+1;i++){
            lst.add(new ArrayList<>());
        }
        for(int[] relation:  relations){
            lst.get(relation[0]).add(relation[1]);
            degree[relation[1]]++;
        }
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for(int i =1;i<degree.length;i++){
            if(degree[i]==0){
                ad.add(i);
            }
        }
        int res = 0;
        boolean[] visited = new boolean[n+1];
        while(!ad.isEmpty()){
            
            int size = ad.size();
            for (int j = 0; j < size; j++) {
                int temp = ad.poll();
                if(visited[temp]){
                    continue;
                }else{
                    visited[temp] = true;
                    List<Integer> next = lst.get(temp);
                    for(int i =0;i< next.size();i++){
                        int tmp = next.get(i);
                        degree[tmp]--;
                        if(degree[tmp]==0){
                            ad.add(tmp);
                        }
                    }
                }
            }

            res++;

        }

        for(int i =1;i<visited.length;i++){
            if(!visited[i]){
                return -1;
            }
        }
        return res;
    }
}