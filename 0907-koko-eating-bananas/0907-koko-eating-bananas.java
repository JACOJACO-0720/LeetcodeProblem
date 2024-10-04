class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //binary search
        if(piles.length==1){
            return piles[0]%h==0?piles[0]/h:piles[0]/h+1 ;
        }
        int left = 1; int right = Integer.MAX_VALUE;
        while(left+1 <right){
            int mid = left +(right-left)/2;
            if(canFinish(piles, h,mid)){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return canFinish(piles, h, left )?left:right;

    }
    boolean canFinish(int[] piles, int h , int speed){
            int res = 0;
            for (int i = 0; i < piles.length; i++) {
                int p = piles[i];
                if(p%speed==0){
                    res += p/speed;
                }else{
                    res+=p/speed+1;
                }
             }


            return res<=h;
    }
}