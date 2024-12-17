class Solution {
    public int hIndex(int[] citations) {
        int hIndexTemp = citations.length;
        while(true){
            int count = 0;
            for(int citation:citations){
                if(citation>=hIndexTemp){
                    count++;
                }
                if(count>=hIndexTemp){
                    return hIndexTemp;
                }   
            }
            hIndexTemp--;
        }
    }
}