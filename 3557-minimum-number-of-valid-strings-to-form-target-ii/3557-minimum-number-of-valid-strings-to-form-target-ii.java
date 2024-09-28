class Solution {
    public int minValidStrings(String[] words, String target) {
        int m = target.length();
        int n = words.length;
        ArrayList<int[]> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(words[i]);
            sb.append('#');
            sb.append(target);
            int[] lps = new int[words[i].length() + m + 1];
            kmp(lps, sb.toString());
            arr.add(lps);
        }
        int total = 0;
        int i = m - 1;
        while(i >= 0) {
            int mm = 0;
            for(int j = 0; j < n; j++) {
                mm = Math.max(mm, arr.get(j)[words[j].length() + 1 + i]);
            }
            if(mm == 0) return -1;
            i -= mm;
            total++;
        }
        return total;
    }
    public static void kmp(int[] lps, String s) {
        int length = 0;
        int i = 1;
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}