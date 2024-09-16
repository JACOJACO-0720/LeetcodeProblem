class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0; int right = matrix.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(matrix[mid][0]<=target && matrix[mid][matrix[0].length-1]>=target){
                return subcheck(mid, matrix, target);
            }else{
                if(matrix[mid][matrix[0].length-1]<target){
                    left = mid+1;
                }else{
                    right= mid-1;
                }
            }
        }
        return false;
    }
    boolean subcheck(int line, int[][] matrix, int target){
        int left = 0; int right = matrix[0].length-1;
        
        while(left<=right){
            int mid = left+(right-left)/2;
            if(matrix[line][mid]==target){
                return true;
            }else{
                if(matrix[line][mid]>target){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
        }
        return false;
    }
}