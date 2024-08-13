class Solution {
    public int candy(int[] ratings) {
        int[] res = new int[ratings.length];
        Arrays.fill(res, 1);

        for (int i = 1; i < ratings.length; i++) {
            if(ratings[i]>ratings[i-1]){
                res[i] = res[i-1]+1;
            }
        }

        for (int i = ratings.length-1; i >=1; i--) {
            if(ratings[i-1]>ratings[i] && res[i-1]<=res[i]){
                res[i-1] = res[i]+1;
            }
        }
        int sum = 0;
        for(int r: res){
            sum += r;
        }
        return sum;
    }
}