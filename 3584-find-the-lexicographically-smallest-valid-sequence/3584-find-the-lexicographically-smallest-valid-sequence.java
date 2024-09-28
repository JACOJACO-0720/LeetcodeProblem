class Solution {
    public int[] validSequence(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        // longestSuffix[i] := the longest length of suffix of word2 in word1[i..]
        int[] longestSuffix = new int[len1 + 1];
        int i2 = len2 - 1;
        for (int i1 = len1 - 1; i1 >= 0; i1--) {
            if (i2 >= 0 && word1.charAt(i1) == word2.charAt(i2)) {
                longestSuffix[i1] = len2 - i2;
                i2--;
            } else {
                longestSuffix[i1] = i1 < len1 - 1 ? longestSuffix[i1 + 1] : 0;
            }
        }
        // Compute the result with longestSuffix
        int[] result = new int[len2];
        int matchedLen = 0;
        boolean replaced = false;
        for (int i1 = 0; i1 < len1; i1++) {
            if (word1.charAt(i1) == word2.charAt(matchedLen)) {
                result[matchedLen] = i1;
                matchedLen++;
            } else if (!replaced && longestSuffix[i1 + 1] >= len2 - matchedLen - 1) {
                // the condition means there exists a solution by replacing words1[i1] 
                replaced = true;
                result[matchedLen] = i1;
                matchedLen++;
            }
            if (matchedLen == word2.length()) return result;
        }
        return new int[]{};
    }
}