class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i =0;i< intervals.length;i++){
            int[] tmp = intervals[i];
            int left = Math.max(tmp[0], toBeRemoved[0]);
            int right = Math.min(tmp[1], toBeRemoved[1]);
            if(toBeRemoved[0]>=tmp[1]||toBeRemoved[1]<=tmp[0]){
                List<Integer> t0 = new ArrayList<>();
                t0.add(tmp[0]);
                t0.add(tmp[1]);
                res.add(t0);
                continue;
            }

            if(tmp[0]< left){
                List<Integer> t0 = new ArrayList<>();
                t0.add(tmp[0]);
                t0.add(left);
                res.add(t0);
            }
            if(tmp[1]>right){
                List<Integer> t1 = new ArrayList<>();
                t1.add(right);
                t1.add(tmp[1]);
                res.add(t1);
            }
        }
        return res;
    }
}