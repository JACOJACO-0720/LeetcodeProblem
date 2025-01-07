class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int max = arrays.get(0).get(arrays.get(0).size()-1);
        int min = arrays.get(0).get(0);
        int res = 0;
        for(int i = 1;i< arrays.size();i++){
            List<Integer> temp = arrays.get(i);
            int curleft = temp.get(0);
            int curright = temp.get(temp.size()-1);
            res = Math.max(res, Math.max(Math.max(Math.abs(min-curleft),Math.abs(min-curright)),Math.max(Math.abs(max-curleft),Math.abs(max-curright))));
            max = Math.max(max,curright);
            min = Math.min(min, curleft);
        }
        return res;
    }
}