import java.util.ArrayDeque;

class Solution {
    public void wallsAndGates(int[][] rooms) {
        ArrayDeque<int[]> ad = new ArrayDeque<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j]==0){
                    ad.add(new int[]{i,j});
                }
            }
        }
        int layer = 0;
        while(!ad.isEmpty()){
            layer++;
            int size = ad.size();
            for (int i = 0; i < size; i++) {
                int[] tmp = ad.pollFirst();
                int tmpx = tmp[0];
                int tmpy = tmp[1];
                //check four side
                if(tmpx-1>=0 && rooms[tmpx-1][tmpy] == Integer.MAX_VALUE){
                    rooms[tmpx-1][tmpy] = layer;
                    ad.add(new int[]{tmpx-1, tmpy});
                }
                if(tmpx+1<rooms.length && rooms[tmpx+1][tmpy] == Integer.MAX_VALUE){
                    rooms[tmpx+1][tmpy] = layer;
                    ad.add(new int[]{tmpx+1, tmpy});
                }
                if(tmpy-1>=0 && rooms[tmpx][tmpy-1] == Integer.MAX_VALUE){
                    rooms[tmpx][tmpy-1] = layer;
                    ad.add(new int[]{tmpx, tmpy-1});
                }
                if(tmpy+1<rooms[0].length && rooms[tmpx][tmpy+1] == Integer.MAX_VALUE){
                    rooms[tmpx][tmpy+1] = layer;
                    ad.add(new int[]{tmpx, tmpy+1});
                }
                
            }
        }

    }
}