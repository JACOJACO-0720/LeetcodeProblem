import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] res = new int[queries.length];
        List<List<Integer>> lst = new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(i+1);
            lst.add(temp);
        }
        int i = 0;
        for (int[] query: queries) {
            lst.get(query[0]).add(query[1]);
            res[i++] = dij(lst,n);
        }
        return res;
    }

    int dij(List<List<Integer>> lst, int n){
        int[] dist = new int[n];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{0,0});

        while(!pq.isEmpty()){

            int[] cur = pq.poll();

            if(cur[1]> dist[cur[0]]){
                continue;
            }
            if(cur[0]==n-1){
                break;
            }
            List<Integer> tmplst = lst.get(cur[0]);
            for (int i = 0; i < tmplst.size(); i++) {
                if(dist[tmplst.get(i)] > cur[1] + 1){
                    dist[tmplst.get(i)] = cur[1] + 1;
                }
                pq.add(new int[]{tmplst.get(i), cur[1] + 1 });
            }

        }
        return dist[n-1];
    }

}