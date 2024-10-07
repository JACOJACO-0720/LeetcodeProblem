class Solution {
    public void setZeroes(int[][] matrix) {
        int[] setColumn = new int[matrix[0].length];
        int[] setRow = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==0){
                    setRow[i]=1;
                    setColumn[j]=1;
                }

            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(setColumn[j]==1||setRow[i]==1){
                    matrix[i][j]=0;
                }

            }
        }




    }
}