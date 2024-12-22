class Solution {
    public int maxArea(int[] height) {
        int square = Integer.MIN_VALUE;
        int left = 0; int right = height.length-1;
        while(left<right){
            square = Math.max(Math.min(height[left], height[right])*(right-left),square);
            if(height[left] < height[right]){
                int originleft = height[left];
                left++;
                while(left<right && height[left]<= originleft){
                    left++;
                }

                if(left>=right){
                    return square;
                }
            }else{
                int originright = height[right];
                right--;
                while(left<right && height[right]<= originright){
                    right--;
                }

                if(left>=right){
                    return square;
                }
            }
        }
        return square;
    }
}