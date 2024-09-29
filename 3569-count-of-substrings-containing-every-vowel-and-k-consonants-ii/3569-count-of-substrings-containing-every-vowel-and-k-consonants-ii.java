class Solution {
    public long countOfSubstrings(String word, int k) {
        long ans = 0;
        int a = 0, e = 0, i = 0, o = 0, u = 0;
        int left = 0;
        // max length of follwing vowel string
        long[] countlast = new long[word.length()];
        for (int index = countlast.length - 1; index >= 0; index--) {
            if (index == countlast.length - 1) {
                countlast[index] = 0;
            }  else {
                if (word.charAt(index + 1) == 'a' || word.charAt(index + 1) == 'e' || word.charAt(index + 1) == 'i' || word.charAt(index + 1) == 'o' || word.charAt(index + 1) == 'u') countlast[index] = countlast[index + 1] + 1;
                else countlast[index] = 0;
            }
        }

        for (int right = 0; right < word.length(); right++) {
            if (word.charAt(right) == 'a') a++;
            if (word.charAt(right) == 'e') e++;
            if (word.charAt(right) == 'i') i++;
            if (word.charAt(right) == 'o') o++;
            if (word.charAt(right) == 'u') u++;

            while (a >= 1 && e >= 1 && i >= 1 && o >= 1 && u >= 1 && (right - left + 1) - a - e - i - o - u >= k) {
                if ((right - left + 1) - a - e - i - o - u == k) {
                    ans += countlast[right];
                    ans++;
                }
                if (word.charAt(left) == 'a') a--;
                if (word.charAt(left) == 'e') e--;
                if (word.charAt(left) == 'i') i--;
                if (word.charAt(left) == 'o') o--;
                if (word.charAt(left) == 'u') u--;
                left++;
            }

        }

        while (left < word.length()) {
            if (a >= 1 && e >= 1 && i >= 1 && o >= 1 && u >= 1 && (word.length() - left) - a - e - i - o - u == k){
                ans++;
            }
            if (word.charAt(left) == 'a') a--;
            if (word.charAt(left) == 'e') e--;
            if (word.charAt(left) == 'i') i--;
            if (word.charAt(left) == 'o') o--;
            if (word.charAt(left) == 'u') u--;
            left++;
        }
        return ans;
    }
}