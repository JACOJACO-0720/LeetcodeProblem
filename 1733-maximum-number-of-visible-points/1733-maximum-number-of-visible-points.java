import java.util.*;

class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int locX = location.get(0);
        int locY = location.get(1);
        int ps = points.size();
        int coin = 0;
        ArrayList<Double> al = new ArrayList<>();
        for (int i = 0; i < ps; i++) {
            List<Integer> tpList = points.get(i);
            int x = tpList.get(0) - locX;
            int y = tpList.get(1) - locY;
            if(x == 0){
                if(y>0){
                    al.add(90.0);
                }
                else if(y<0){
                    al.add(-90.0);
                }else{
                    coin++;
                }
            }else{
                double degree = Math.toDegrees(Math.atan2(y, x));
                if (degree > 180) {
                    degree -= 360;
                } else if (degree < -180) {
                    degree += 360;
                }
                al.add(degree);
            }
        }
        Collections.sort(al);
        int alsize = al.size();
        for (int i = 0; i < alsize; i++) {
            al.add(al.get(i)+360);
        }
        int left = 0; int right = 0;
        int res = 0;
        int curRes = 0;
        while(right<al.size()){
            if(al.get(right)-al.get(left)<=angle ){
                curRes++;
                right++;
                if(curRes>res){
                    res = curRes;
                }
            }else{
                curRes--;
                left++;
            }
        }
        return res+coin;

    }
}