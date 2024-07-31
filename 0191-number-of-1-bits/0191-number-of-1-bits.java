class Solution {
    public int hammingWeight(int n) {
        String str = Integer.toBinaryString(n);
        int res= 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='1'){
                res++;
            }
        }
        return res;
    }
}