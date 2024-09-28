class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int result = 1;
        int length = points.length;
        int i = 0;
        int start;
        int end = points[0][1];
        while (i < length-1) {
            i++;
            start = points[i][0];
            end = Math.min(points[i][1], end);
            if (start > end) {
                result++;
                end = points[i][1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //int[][] points = new int[][]{{10,16},{2,8},{1,6},{7,12}};
        int[][] points = new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        Solution solution = new Solution();
        System.out.println(solution.findMinArrowShots(points));
    }
}