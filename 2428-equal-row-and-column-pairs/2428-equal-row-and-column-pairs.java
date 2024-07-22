class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String,Integer> rowMap= new HashMap<>();
        HashMap<String,Integer> columnMap= new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < grid.length; j++) {
                sb.append(grid[i][j]);
                sb.append("?");
            }
            int temp = rowMap.getOrDefault(sb.toString(), 0);
            rowMap.put(sb.toString(),temp+1);
        }

        for (int i = 0; i < grid.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < grid.length; j++) {
                sb.append(grid[j][i]);
                sb.append("?");
            }
            int temp = columnMap.getOrDefault(sb.toString(), 0);
            columnMap.put(sb.toString(),temp+1);
        }//(2*n2)
        int result = 0;
        Iterator<Map.Entry<String, Integer>> it = rowMap.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String,Integer> en = it.next();
            String tempKey = en.getKey();
            int tempValue = en.getValue();
            result += (tempValue*columnMap.getOrDefault(tempKey,0));
        }
        return result;

    }
    
}