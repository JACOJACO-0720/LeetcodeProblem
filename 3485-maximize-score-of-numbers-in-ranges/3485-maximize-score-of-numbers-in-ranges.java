import java.util.Arrays;

class Solution {
    public int maxPossibleScore(int[] start, int d) {
        Arrays.sort(start);
        
        int n = start.length;
        

        int low = 0, high = ((start[n - 1]+d) - (start[0] -d>=0?start[0] -d:0))/(start.length-1)+start.length;  
        int result = 0;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;  
            
            if (canAchieveScore(start, d, mid)) {
                result = mid; 
                low = mid + 1; 
            } else {
                high = mid - 1; 
            }
        }
        
        return result; 
    }
    
    private boolean canAchieveScore(int[] start, int d, int score) {
        int prev = start[0]; 
        
        for (int i = 1; i < start.length; i++) {
            int next = Math.max(prev + score, start[i]);  
            
            if (next > start[i] + d) {  
                return false;
            }
            
            prev = next; 
        }
        
        return true;  
    }

}
