class Solution {
    public long validSubstringCount(String word1, String word2) {
        HashMap<Character, Integer> word2hm = new HashMap<>();
        int distinctCount = 0;
        for (int i = 0; i < word2.length(); i++) {
            if (!word2hm.containsKey(word2.charAt(i))) {
                distinctCount++;
            }
            int temp = word2hm.getOrDefault(word2.charAt(i), 0) + 1;
            word2hm.put(word2.charAt(i), temp);
        }
        long res = 0;
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> tmphm = new HashMap<>();
        int tempcnt = 0;
        int leftleft = 0;
        while (left < word1.length() && right < word1.length()) {
            char temp = word1.charAt(right);
            if (!word2hm.containsKey(temp)) {
                right++;
            } else {
                int c = tmphm.getOrDefault(temp, 0) + 1;
                tmphm.put(temp, c);
                if (c == word2hm.get(temp)) {
                    tempcnt++;

                    if (tempcnt == distinctCount) {
                        while (tempcnt == distinctCount) {
                            char t = word1.charAt(left);
                            if (tmphm.containsKey(t)) {
                                int tc = tmphm.get(t);
                                tc--;
                                tmphm.put(t, tc);
                                if (tc < word2hm.get(t)) {

                                    tempcnt--;
                                    res += (left-leftleft+1)*(word1.length() - right);
                                    left++;
                                    leftleft = left;
                                }else{
                                    left++;
                                }

                            }else{
                                left++;
                            }

                        }
                    }

                }
                right++;
            }

        }
        return res;
    }
}