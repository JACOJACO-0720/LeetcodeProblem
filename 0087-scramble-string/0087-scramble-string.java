import java.util.HashMap;

class Solution {
    // HashMap 用于存储已经计算过的子问题
    private HashMap<String, Boolean> memo = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }

        // 生成一个唯一的 key，用于在 HashMap 中存储和查找
        String key = s1 + ":" + s2;
        
        // 如果已经计算过这个子问题，直接返回结果
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int len = s1.length();
        for (int i = 1; i < len; i++) {
            // 情况1：交换的情况
            if (isScramble(s1.substring(0, i), s2.substring(len - i)) &&
                isScramble(s1.substring(i), s2.substring(0, len - i))) {
                memo.put(key, true);
                return true;
            }

            // 情况2：不交换的情况
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                isScramble(s1.substring(i), s2.substring(i))) {
                memo.put(key, true);
                return true;
            }
        }

        // 如果没有找到符合的情况，存入 false
        memo.put(key, false);
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isScramble("great", "rgeat")); // 输出 true
        System.out.println(solution.isScramble("abc", "bca"));     // 输出 false
    }
}
