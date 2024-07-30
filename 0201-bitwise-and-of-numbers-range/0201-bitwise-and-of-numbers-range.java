class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        if(left==right){
            return left;
        }
        int shift = 0;
        while(left!=right){
            left =left>>1;
            right = right>>1;
            shift++;
        }
        for (int i = 0; i < shift; i++) {
            left=left<<1;
        }
        return left;
    }
}