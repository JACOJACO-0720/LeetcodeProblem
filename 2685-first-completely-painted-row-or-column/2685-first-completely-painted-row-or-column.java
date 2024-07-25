import java.util.HashMap;

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Node[] array = new Node[mat.length*mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j <mat[0].length ; j++) {
                Node tempN= new Node(i,j);
                array[mat[i][j]-1] = tempN;
            }
        }

        int[] ra = new int[mat.length];
        int[] ca =  new int[mat[0].length];
        boolean raq = true;
        boolean caq = true;
        int count = 0;
        while (raq && caq) {
            
            
            Node tempNode = array[arr[count]-1];
            ra[tempNode.x]++;
            ca[tempNode.y]++;
            count++;
            if(raq){
                if(ra[tempNode.x]==mat[0].length){
                    return count-1;
                }
            }
            if(caq){
                if(ca[tempNode.y]==mat.length){
                    return count-1;
                }
            }
            
            

        }
        return count-1;

    }
    class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}