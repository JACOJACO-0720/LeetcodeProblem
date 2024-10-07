import java.util.Stack;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[][] ar = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            if(matrix[0][i]=='0'){
                ar[0][i] = 0;
            }else{
                ar[0][i] = 1;
            }
        }
        for (int i = 1; i < ar.length; i++) {
            for (int j = 0; j < ar[0].length; j++) {
                if(matrix[i][j]=='0'){
                    ar[i][j] = 0;
                }else{
                    ar[i][j] = ar[i-1][j]+1;
                }
            }
        }
        int max  = 0;
        for (int i = 0; i < ar.length; i++) {
            max = Math.max(max, findMax(ar[i]));
        }
        return max;

    }
    int findMax(int[] input){
    int max = 0;
    Stack<int[]> stk = new Stack<>();
    
    for (int i = 0; i < input.length; i++) {
        int temp = input[i];
        
        while (!stk.isEmpty() && stk.peek()[0] > temp) {
            int[] t = stk.pop();
            // 注意这里宽度计算的修正
            int width = i - (stk.isEmpty() ? -1 : stk.peek()[1]) - 1;
            max = Math.max(max, t[0] * width);
        }
        
        stk.push(new int[]{temp, i});
    }

    // 清空栈中剩余的柱子
    while (!stk.isEmpty()) {
        int[] t = stk.pop();
        // 注意这里宽度计算的修正
        int width = input.length - (stk.isEmpty() ? -1 : stk.peek()[1]) - 1;
        max = Math.max(max, t[0] * width);
    }

    return max;
}

}