class Solution {
    public int generateKey(int num1, int num2, int num3) {
        int res = 0;
        
        for(int i =0;i<4;i++){
            int tmp1 = (num1/(int)Math.pow(10,3-i))%10;
            int tmp2 = (num2/(int)Math.pow(10,3-i))%10;
            int tmp3 = (num3/(int)Math.pow(10,3-i))%10;
            int digit = Math.min(tmp1, Math.min(tmp2, tmp3));
            res += digit * (int)Math.pow(10,3-i);
        }
        return res;
    }
}