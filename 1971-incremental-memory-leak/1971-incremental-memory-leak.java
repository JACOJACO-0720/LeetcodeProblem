class Solution {
    public int[] memLeak(int memory1, int memory2) {
        int cur = 1;
        while(memory1>=cur && memory2>=cur){
            if(memory1>=memory2){
                memory1-=cur;
            }else{
                memory2-=cur;
            }
            cur++;
        }
        if(memory1<cur && memory2<cur){
            return new int[]{cur, memory1, memory2};
        }else if(memory1>=cur){
                while(memory1>=cur){
                    memory1 = memory1-cur;
                    cur++;
                }
            return new int[]{cur, memory1, memory2};
        }else{
            while(memory2>=cur){
                memory2 = memory2-cur;
                cur++;
            }
            return new int[]{cur, memory1, memory2};
        }
    }
}