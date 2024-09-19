class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        int position=0;
        while(position<strs[0].length()) {
            char currentPositionChar=strs[0].charAt(position);
            for (int i = 1; i <strs.length; i++) {
                if(position>=strs[i].length()||currentPositionChar!=strs[i].charAt(position)){
                    return result.toString();
                }
            }
            result.append(currentPositionChar);
            position++;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(strs));
    }
}