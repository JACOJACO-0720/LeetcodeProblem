class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0; int right = matrix.length-1;
        while(left<=right){
            int mid = left +(right-left)/2;
            if(target>=matrix[mid][0] && target<=matrix[mid][matrix[0].length-1]){
                return searchInSingleRow(matrix[mid], target);
            }else if(target < matrix[mid][0]){
                right = mid-1;

            }else{
                left = mid+1;
            }
        }
        return false;

    }
    boolean searchInSingleRow(int[] matrix, int target){
        int left = 0; int right = matrix.length-1;
        while(left<=right){
            int mid = left +(right-left)/2;
            if(target==matrix[mid]){
                return true;
            }else if(target<=matrix[mid]){
                right=mid-1;
            }else{
                left = mid+1;
            }
        }
        return false;
    }
}