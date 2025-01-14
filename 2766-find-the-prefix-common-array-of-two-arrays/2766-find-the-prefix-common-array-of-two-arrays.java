class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] res = new int[A.length];
        HashSet<Integer> hs1 = new HashSet<>();
        HashSet<Integer> hs2 = new HashSet<>();
        for(int i =0;i< A.length; i++){
            int tempA = A[i];
            int tempB = B[i];
            int r = 0;
            if(!hs1.contains(tempA)){
                hs1.add(tempA);
                if(hs2.contains(tempA)){
                    r++;
                }
            }
            if(!hs2.contains(tempB)){
                hs2.add(tempB);
                if(hs1.contains(tempB)){
                    r++;
                }
            }
            if(i==0){
                res[0] = r;
            }else{
                res[i] = res[i-1]+r;
            }
        }
        return res;
    }
}