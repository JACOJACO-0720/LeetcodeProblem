class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {

        int[] stat = new int[n];

        for(List<Integer> edge: edges){
            stat[edge.get(1)]++;
        }
        
        List<Integer> res = new ArrayList<>() ;
        for (int i = 0; i < stat.length; i++) {
            if(stat[i]==0){
                res.add(i);
            }
        }

        return res;
    }
}