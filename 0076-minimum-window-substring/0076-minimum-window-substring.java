class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        int[] dir = new int[52];
        for (int i = 0; i < dir.length; i++) {
            dir[i] = Integer.MIN_VALUE;
        }
        int tlength = t.length();
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) >= 'a' && t.charAt(i) <= 'z') {
                if (dir[t.charAt(i) - 'a'] == Integer.MIN_VALUE) {
                    dir[t.charAt(i) - 'a'] = 1;
                } else {
                    dir[t.charAt(i) - 'a']++;
                }
            } else {
                if (dir[t.charAt(i) - 'A' + 26] == Integer.MIN_VALUE) {
                    dir[t.charAt(i) - 'A' + 26] = 1;
                } else {
                    dir[t.charAt(i) - 'A' + 26]++;
                }
            }
        }
        int[] maxArray = dir.clone();
        int count = 0;
        int left = 0;
        int right = tlength - 1;
        int maxLength = Integer.MAX_VALUE;
        String maxString = "";
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                if (dir[s.charAt(i) - 'a'] == Integer.MIN_VALUE) {
                     if (count == t.length()) {
                            if (right - left + 1 < maxLength) {
                                 maxLength = right - left + 1;
                                maxString = s.substring(left, right+1);
                                        if(maxLength == t.length()){
                                            return maxString;
                                        }
                            }
                    }
                } else {
                    dir[s.charAt(i) - 'a']--;
                    if (dir[s.charAt(i) - 'a'] >= 0) {
                        count++;
                        if (count == t.length()) {
                            if (right - left + 1 < maxLength) {
                                 maxLength = right - left + 1;
                                maxString = s.substring(left, right+1);
                                        if(maxLength == t.length()){
                                            return maxString;
                                        }
                            }
                        }
                    }
                }
            } else {
                if (dir[s.charAt(i) - 'A' + 26] == Integer.MIN_VALUE) {
                     if (count == t.length()) {
                            if (right - left + 1 < maxLength) {
                                 maxLength = right - left + 1;
                                maxString = s.substring(left, right+1);
                                        if(maxLength == t.length()){
                                            return maxString;
                                        }
                            }
                        }
                } else {
                    dir[s.charAt(i) - 'A'+ 26]--;
                    if (dir[s.charAt(i) - 'A'+ 26] >= 0) {
                        count++;
                        if (count == t.length()) {
                            if (right - left + 1 < maxLength) {
                                 maxLength = right - left + 1;
                                maxString = s.substring(left, right+1);
                                        if(maxLength == t.length()){
                                            return maxString;
                                        }
                            }
                        }
                    }
                }
            }
        }


        while (right < s.length()) {
            if (count == t.length()) {
                int originLeft = left;
                left++;
                if (s.charAt(originLeft) >= 'a' && s.charAt(originLeft) <= 'z') {
                    if (dir[s.charAt(originLeft) - 'a'] == Integer.MIN_VALUE) {
                         if (count == t.length()) {
                            if (right - left + 1 < maxLength) {
                                 maxLength = right - left + 1;
                                maxString = s.substring(left, right+1);
                                        if(maxLength == t.length()){
                                            return maxString;
                                        }
                            }
                        }
                    } else {
                        dir[s.charAt(originLeft) - 'a']++;
                        if (dir[s.charAt(originLeft) - 'a'] > 0) {
                            count--;
                        }
                    }
                    if (count == t.length()) {
                        if (right - left + 1 < maxLength) {
                            maxLength = right - left + 1;
                            maxString = s.substring(left, right+1);
                                        if(maxLength == t.length()){
                                            return maxString;
                                        }
                        }
                    }
                } else {
                    if (dir[s.charAt(originLeft) - 'A'+ 26] == Integer.MIN_VALUE) {
                         if (count == t.length()) {
                            if (right - left + 1 < maxLength) {
                                maxLength = right - left + 1;
                                maxString = s.substring(left, right+1);
                                        if(maxLength == t.length()){
                                            return maxString;
                                        }
                            }
                        }
                    } else {
                        dir[s.charAt(originLeft) - 'A'+ 26]++;
                        if (dir[s.charAt(originLeft) - 'A'+ 26] > 0) {
                            count--;
                        }
                    }
                    if (count == t.length()) {

                        if (right - left + 1 < maxLength) {
                            maxLength = right - left + 1;
                            maxString = s.substring(left, right+1);
                                        if(maxLength == t.length()){
                                            return maxString;
                                        }
                        }
                    }
                }
            } else {
                right++;
                if (right >= s.length()) {
                    return maxString;
                } else {
                    if (s.charAt(right) >= 'a' && s.charAt(right) <= 'z') {
                        if (dir[s.charAt(right) - 'a'] == Integer.MIN_VALUE) {
                            continue;
                        } else {
                            dir[s.charAt(right) - 'a']--;
                            if (dir[s.charAt(right) - 'a'] >= 0) {
                                count++;
                                if (count == t.length()) {
                                    if (right - left + 1 < maxLength) {
                                        maxLength = right - left + 1;
                                        maxString = s.substring(left, right+1);
                                        if(maxLength == t.length()){
                                            return maxString;
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        if (dir[s.charAt(right) - 'A' + 26] == Integer.MIN_VALUE) {
                            continue;
                        } else {
                            dir[s.charAt(right) - 'A'+ 26]--;
                            if (dir[s.charAt(right) - 'A'+ 26] >= 0) {
                                count++;
                                if (count == t.length()) {
                                    if (right - left + 1 < maxLength) {
                                        maxLength = right - left + 1;

                                        maxString = s.substring(left, right+1);
                                        if(maxLength == t.length()){
                                            return maxString;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }


        }
        return maxString;
    }
}