class Solution {

    int[] range = new int[4];
    public int minArea(char[][] image, int x, int y) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        range[0] = Integer.MAX_VALUE;
        range[1] = Integer.MIN_VALUE;
        range[2] = Integer.MAX_VALUE;
        range[3] = Integer.MIN_VALUE;
         


        dfs(image, visited, x, y);
        
        return (range[1]-range[0]+1) * (range[3]-range[2]+1); 
    }
    
    void dfs(char[][] image, boolean[][] visited, int x , int y){
        if(outofbound(x, y, image) || visited[x][y] || image[x][y]=='0'){
            return;
        }
        visited[x][y] = true;
        
        range[0] = Math.min(range[0], x);
        range[1] = Math.max(range[1], x);

        range[2] = Math.min(range[2], y);
        range[3] = Math.max(range[3], y);
        dfs(image, visited, x+1, y);
        dfs(image, visited, x-1, y);
        dfs(image, visited, x, y+1);
        dfs(image, visited, x, y-1);
        
    }
    
    
    boolean outofbound(int x, int y, char[][] images){
        if(x<0 || x >= images.length||y<0||y>=images[0].length){
            return  true;
        }
        return false;
    }
}