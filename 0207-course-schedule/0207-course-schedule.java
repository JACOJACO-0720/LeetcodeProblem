import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==1){
            return true;
        }
        int remain = numCourses;
        List<List<Integer>> adjList = new ArrayList<>();
        List<List<Integer>> revList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            List<Integer> temp1 = new ArrayList<>();
            List<Integer> temp2 = new ArrayList<>();
            adjList.add(temp1);
            revList.add(temp2);
        }


        for (int[] prerequisite: prerequisites) {
            adjList.get(prerequisite[0]).add(prerequisite[1]);
            revList.get(prerequisite[1]).add(prerequisite[0]);
        }

        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for(int i =0;i< adjList.size();i++){
            if(adjList.get(i).isEmpty()){
                ad.add(i);
            }
        }
        while(!ad.isEmpty()){
            int temp = ad.poll();
            remain--;
            List<Integer> rev = revList.get(temp);

            for (int i = 0; i < rev.size(); i++) {
                adjList.get(rev.get(i)).remove(Integer.valueOf(temp));
                if(adjList.get(rev.get(i)).isEmpty()){
                    ad.add(rev.get(i));
                }
            }

        }
        return remain == 0;

    }
}