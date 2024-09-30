class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum =0;
        int max = 0;
        for(int i: weights){
            sum+=i;
            max= Math.max(max,i);
        }
        int left = 0;
        if(sum%days==0){
            left = sum/days;
        } else{
            left = sum/days+1;
        }
        left = Math.max(max,left);

        int right = sum;
        while(left+1<right){
            int mid = left+(right-left)/2;
            if(!helperFunction(mid, weights, days)){
                left=mid;
            }else{
                right = mid;
            }
        }
        if(helperFunction(left, weights, days)){
            return left;
        }
        return right;


    }
    boolean helperFunction(int volumn, int[] weight, int days){
        int current = volumn;
        int count = 1;
        for (int i = 0; i < weight.length; i++) {
            if(current>=weight[i]){
                current-=weight[i];
            }else{
                count++;
                if(count>days){
                    return false;
                }
                current = volumn;
                current-=weight[i];

            }
        }
        return true;
    }

}