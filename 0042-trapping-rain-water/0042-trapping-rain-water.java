class Solution {
    public int trap(int[] height) {
        int[] lagestRight = new int[height.length];
         int[] lagestLeft = new int[height.length];
         int max = 0;
         for (int i = 0; i < height.length; i++) {
             lagestLeft[i] = max;
            if(height[i]>max){
                max = height[i]; 
            }
         }
            max = 0;
         for (int i = height.length-1; i >=0; i--) {
            lagestRight[i] = max;
            if(height[i]>max){
                max = height[i];   
            }
         }

        int sum = 0;

        for (int i = 0; i < height.length; i++) {
            int addWaterHeight = Math.min( lagestLeft[i] , lagestRight[i]);
            if(addWaterHeight>height[i]){
                sum+= addWaterHeight-height[i];
            }
        }
        return sum;

    }
}