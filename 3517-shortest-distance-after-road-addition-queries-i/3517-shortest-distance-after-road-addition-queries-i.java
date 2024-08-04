import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] res = new int[queries.length];
        List<List<Integer>> lst = new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(i+1);
            lst.add(tmp);
        }
        lst.add(new ArrayList<>());
        int i =0;
        for(int[] query: queries){
            int l = query[0];
            int r = query[1];
            lst.get(l).add(r);
            res[i++] = bellmanFord( res, lst,n);
        }
        return res;
    }
    int  bellmanFord( int[] res , List<List<Integer>> lst, int n){
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.add(0);
        while(!ad.isEmpty()){
            int temp = ad.poll();
            List<Integer> tmp = lst.get(temp);
            for (int i = 0; i < tmp.size(); i++) {
                if(distance[tmp.get(i)]> distance[temp]+1){
                    distance[tmp.get(i)] = distance[temp]+1;
                    ad.push(tmp.get(i));
                }
            }

        }
        return distance[n-1];
    }

}