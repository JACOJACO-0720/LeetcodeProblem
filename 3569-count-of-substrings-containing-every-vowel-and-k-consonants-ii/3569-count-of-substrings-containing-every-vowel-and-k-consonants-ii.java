class Solution {
    public long count(String word, int k) {
        if (k < 0) {
            return 0;
        }
        
        Map<Character, Integer> hmap = new HashMap<>();
        int cons = 0;
        int left = 0;
        long ans = 0;
        String vowel = "aeiou";
        int n = word.length();
        for (int right = 0; right < word.length(); right++) {
            char currentChar = word.charAt(right);
            if (vowel.indexOf(currentChar) >= 0) {
                hmap.put(currentChar, hmap.getOrDefault(currentChar, 0) + 1);
            } else {
                cons++;
            }
            while (cons >= k && hmap.getOrDefault('a', 0) > 0 &&
                hmap.getOrDefault('e', 0) > 0 &&
                hmap.getOrDefault('i', 0) > 0 &&
                hmap.getOrDefault('o', 0) > 0 &&
                hmap.getOrDefault('u', 0) > 0) {
                    ans+=(n-right);
                char leftChar = word.charAt(left);
                if (vowel.indexOf(leftChar) >= 0) {
                    hmap.put(leftChar, hmap.get(leftChar) - 1);
                } else {
                    cons--;
                }
                left++;
            }
        }
        return ans;
    }

    public long countOfSubstrings(String word, int k) {
        long val1 = count(word,k);
        long val2 = count(word,k+1);
        return val1-val2;
    }
}