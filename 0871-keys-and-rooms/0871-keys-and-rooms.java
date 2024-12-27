class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()]; 
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        int res = 0;
        ad.add(0);
        while(!ad.isEmpty()){
            int size = ad.size();
            for (int i = 0; i < size; i++) {
                int tmp = ad.pollFirst();
                if(visited[tmp]){
                    continue;
                }else{
                    res++;
                    visited[tmp] = true;
                    List<Integer> next = rooms.get(tmp);
                    for (int j = 0; j < next.size(); j++) {
                        ad.add(next.get(j));
                    }
                }
            }
        }
        return res==rooms.size();
    }
}