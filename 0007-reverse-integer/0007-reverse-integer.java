class Solution {
    public int reverse(int x) {
        boolean isnegative = false;

        if (x < 0) {
            isnegative = true;
        }

        String str = Integer.toString(x);
        String maxIntegerstr = String.valueOf(Integer.MAX_VALUE);
        String minIntegerstr = String.valueOf(Integer.MIN_VALUE);
        if (isnegative) {
            if (str.length() == minIntegerstr.length()) {
                for (int i = 1; i < str.length(); i++) {
                    if (minIntegerstr.charAt(i) < str.charAt(str.length() - i)) {
                        return 0;
                    }else if(minIntegerstr.charAt(i) > str.charAt(str.length() - i)){
                        break;
                    }
                }
            }
            StringBuilder sb = new StringBuilder(str);
            int left = 1;
            int right = sb.length() - 1;
            while (left < right) {
                char temp = sb.charAt(left);
                sb.setCharAt(left, sb.charAt(right));
                sb.setCharAt(right, temp);
                left++;
                right--;
            }
            return Integer.valueOf(sb.toString());
        } else {
            if (str.length() == maxIntegerstr.length()) {
                for (int i = 0; i < str.length(); i++) {
                    if (maxIntegerstr.charAt(i) < str.charAt(str.length() - 1 - i)) {
                        return 0;
                    }else if(maxIntegerstr.charAt(i) > str.charAt(str.length() -1- i)){
                        break;
                    }
                }
            }
            StringBuilder sb = new StringBuilder(str);
            int left = 0;
            int right = sb.length() - 1;
            while (left < right) {
                char temp = sb.charAt(left);
                sb.setCharAt(left, sb.charAt(right));
                sb.setCharAt(right, temp);
                left++;
                right--;
            }
            return Integer.valueOf(sb.toString());
        }

    }
}