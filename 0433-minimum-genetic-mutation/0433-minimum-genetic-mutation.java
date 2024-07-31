import java.util.ArrayDeque;

class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        int minSum = 0;
        int[] visited  =new int[bank.length];
        ArrayDeque<String> ad = new ArrayDeque<>();
        ad.add(startGene);
        while(!ad.isEmpty()){
            int size = ad.size();
            for (int i = 0; i < size; i++) {
                String tempStr = ad.poll();
                for (int j = 0; j < bank.length; j++) {
                    if(visited[j]==0 && isDiff1(tempStr, bank[j])){
                        visited[j]=1;
                        ad.addLast(bank[j]);
                        if(endGene.equals(bank[j])){
                            return minSum+1;
                        }
                    }
                    
                }
            }
            minSum++;
        }
        return -1;
        
    }

    boolean isDiff1(String s1, String s2){
        int sum = 0;
        for (int i = 0; i < 8; i++) {
            if(s1.charAt(i)!=s2.charAt(i)){
                sum++;
            }
        }
        if(sum==1){
            return true;
        }else{
            return false;
        }
    }
}