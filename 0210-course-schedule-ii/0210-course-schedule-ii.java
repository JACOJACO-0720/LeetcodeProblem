import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>(numCourses);
        List<List<Integer>> revlist = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
            revlist.add(new ArrayList<>());
        }

        for (int[] temp: prerequisites ) {
            list.get(temp[0]).add(temp[1]);
            revlist.get(temp[1]).add(temp[0]);
        }


        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for (int i = 0;i<list.size();i++) {
            if(list.get(i).isEmpty()){
                ad.add(i);
            }
        }
        while(!ad.isEmpty()){
            int size = ad.size();
            for (int i = 0; i < size; i++) {
                int tempint = ad.poll();
                res.add(tempint);
                List<Integer> tmpreverse = revlist.get(tempint);
                if(tmpreverse.isEmpty()){
                    continue;
                }else{
                    for (int j = 0; j < tmpreverse.size() ;j++) {
                        int temprevint = tmpreverse.get(j);
                        list.get(temprevint).remove(Integer.valueOf(tempint));
                        if(list.get(temprevint).isEmpty()){
                            ad.add(temprevint);
                        }
                    }
                }
            }

        }
        if(res.size()!=numCourses){
            return new int[0];
        }else{
            int[] resarray = new int[numCourses];
            for (int i = 0; i < resarray.length; i++) {
                resarray[i]= res.get(i);
            }
            return resarray;
        }
    }
}