import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class Solution {

    public int minNumberOperations(int[] target) {
        HashSet<Integer> hs = new HashSet<>();
        int cur = 0;
        int res = 0;
        if(target.length==1){
            return target[0];
        }
        List<int[]> lst = new ArrayList<>();
        for(int i =0;i<target.length;i++){
            int[] tmp = new int[2];
            tmp[0] = target[i];
            tmp[1] = i;
            lst.add(tmp);
        }
        Collections.sort(lst, (n1, n2)->(Integer.compare(n1[0], n2[0])));




        int curHeight = lst.getLast()[0];
        List<Integer> tmp = new ArrayList<>();
        int lastHeight = -1;

        while(!lst.isEmpty()){
            tmp = new ArrayList<>();
            curHeight = lst.getLast()[0];
            while(!lst.isEmpty() && lst.getLast()[0]==curHeight){
                tmp.add(lst.getLast()[1]);
                lst.removeLast();
            }
            if(lastHeight!=-1){
                res += (lastHeight- curHeight) * cur;
                lastHeight = curHeight;
            }else{
                lastHeight = curHeight;
            }
            cur = merge(tmp,hs,cur);
            
        }
        res += (lastHeight) * cur;


        return res;
    }


    int merge(List<Integer> tmp, HashSet<Integer> hs, int cur){
        for(int i = 0;i<tmp.size();i++){
            int temp = tmp.get(i);
            hs.add(temp);
            if(!hs.contains(temp-1)&&!hs.contains(temp+1)){
                cur++;
            }else if(hs.contains(temp-1)&&hs.contains(temp+1)){
                cur--;
            }
        }
        return cur;
    }
}