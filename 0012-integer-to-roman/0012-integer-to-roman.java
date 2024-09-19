public class Solution {

    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int fourDigit = num / 1000;
        int threeDigit = (num % 1000) / 100;
        int twoDigit = (num%100)/10;
        int oneDigit = num % 10;
            for (int i = 0; i < fourDigit; i++) {
                result.append("M");
            }
            if (threeDigit == 9) {
                result.append("CM");
            } else if (threeDigit > 4) {
                result.append("D");
                for (int i = 0; i < threeDigit - 5; i++) {
                    result.append("C");
                }
            }
            else if (threeDigit == 4) {
                result.append("CD");
            }
            else{
                for (int i = 0; i < threeDigit; i++) {
                    result.append("C");
                }
            }
            if (twoDigit == 9) {
                result.append("XC");
            } else if (twoDigit > 4) {
                result.append("L");
                for (int i = 0; i < twoDigit - 5; i++) {
                    result.append("X");
                }
            }
            else if (twoDigit == 4) {
                result.append("XL");
            }
            else{
                for (int i = 0; i < twoDigit; i++) {
                    result.append("X");
                }
            }
            if (oneDigit == 9) {
                result.append("IX");
            } else if (oneDigit > 4) {
                result.append("V");
                for (int i = 0; i < oneDigit - 5; i++) {
                    result.append("I");
                }
            }
            else if (oneDigit == 4) {
                result.append("IV");
            }
            else{
                for (int i = 0; i < oneDigit; i++) {
                    result.append("I");
                }
            }
        

        return result.toString();

    }

    public static void main(String[] args) {
        int test = 1994;
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(test));
    }

}
