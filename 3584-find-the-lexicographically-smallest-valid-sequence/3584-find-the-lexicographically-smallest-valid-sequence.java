class Solution {
    public int[] validSequence(String word1, String word2) {
        int i = 0, j = 0;
        int[] res = new int[word2.length()];
        while (i < word1.length() && j < word2.length() && word1.charAt(i) == word2.charAt(j)) {
            res[j++] = i++;
        }
        while (i < word1.length() && j < word2.length()) {
            if (find(word1, word2, i + 1, j + 1, res)) {
                res[j] = i;
                return res;
            }
            while (i < word1.length()) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    while (i < word1.length() && j < word2.length() && word1.charAt(i) == word2.charAt(j)) {
                        res[j++] = i++;
                    }
                    break;
                } else {
                    i++;
                }
            }
        }
        if (j < word2.length()) {
            return new int[]{};
        }
        return res;
    }

    static boolean find(String w1, String w2, int i, int j, int[] res) {
        while (i < w1.length() && j < w2.length()) {
            if (w1.charAt(i) == w2.charAt(j)) {
                res[j++] = i++;
            } else {
                i++;
            }
        }
        return j == w2.length();
    }

}