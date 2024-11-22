/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        boolean[] isCelebrity  = new boolean[n];
        Arrays.fill(isCelebrity, true);

        for(int i =0;i<n;i++){
            if(!isCelebrity[i]){
                continue;
            }

            int unknownum  = 0;
            for (int j = 0; j < n; j++) {
                if(i == j){
                    continue;
                }else{
                    if(knows(i, j)){
                        isCelebrity[i] = false;
                        break;
                    }else{
                        if(!knows(j, i)){
                            isCelebrity[i] = false;
                            break;
                        }
                        unknownum++;
                    }
                }
            }
            if(unknownum==n-1){
                
                return i;
            }
        }
        return -1;
    }
}