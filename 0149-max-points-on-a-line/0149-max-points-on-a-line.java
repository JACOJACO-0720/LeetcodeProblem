class Solution {
    public int maxPoints(int[][] points) {
        int pointlength = points.length;
        int result = 0;
        if(pointlength<2){
            return pointlength;
        }

        for (int i = 0; i < pointlength; i++) {
            int maxValue = 2;
            int[] currentPoint = points[i];
            HashMap<Float,Integer> hm = new HashMap<>();
            int verticalPointCnt = 1;
            for (int j = 0; j < pointlength; j++) {
                if(i==j){
                    continue;
                }else{
                    int[] tempPoint = points[j];
                    if(currentPoint[0]==tempPoint[0]){
                        verticalPointCnt++;

                    }else{
                        int tempvalue = 0;
                        float slop = (tempPoint[1]-currentPoint[1])/(float)(tempPoint[0]-currentPoint[0]);
                        if(slop==-0.0){
                            slop = 0;
                        }
                        if(!hm.containsKey(slop)){
                            hm.put(slop,2);
                            tempvalue = 2;
                        }else{
                            tempvalue= hm.get(slop);
                            hm.put(slop, tempvalue+1);
                            tempvalue++;
                            if(tempvalue>maxValue){
                            maxValue = tempvalue;
                            }
                        }
                    }
                        
                }

            }
            if(verticalPointCnt>maxValue){
                maxValue = verticalPointCnt;
            }
            result = Math.max(result,maxValue);
            if(result>pointlength/2){
                return result;
            }
        }
        return result;
    }
}