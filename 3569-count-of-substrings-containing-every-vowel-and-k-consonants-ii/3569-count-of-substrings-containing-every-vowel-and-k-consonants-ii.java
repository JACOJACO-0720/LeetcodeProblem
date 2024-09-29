class Solution {
    public long countOfSubstrings(String word, int k) {
        long ans = 0;
        int[] vowels = new int[5]; // 用于计数 'a', 'e', 'i', 'o', 'u'
        int left = 0;

        // 计算每个位置的元音连续长度
        long[] countLast = new long[word.length()];
        for (int index = word.length() - 2; index >= 0; index--) {
            countLast[index] = isVowel(word.charAt(index + 1)) ? countLast[index + 1] + 1 : 0;
        }

        for (int right = 0; right < word.length(); right++) {
            updateVowelCount(word.charAt(right), vowels, 1);

            while (allVowelsPresent(vowels) && (right - left + 1) - sumVowels(vowels) >= k) {
                if ((right - left + 1) - sumVowels(vowels) == k) {
                    ans += countLast[right] + 1;
                }
                updateVowelCount(word.charAt(left), vowels, -1);
                left++;
            }
        }

        return ans;
    }

    // 判断是否为元音
    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }

    // 更新元音计数数组
    private void updateVowelCount(char c, int[] vowels, int delta) {
        switch (c) {
            case 'a': vowels[0] += delta; break;
            case 'e': vowels[1] += delta; break;
            case 'i': vowels[2] += delta; break;
            case 'o': vowels[3] += delta; break;
            case 'u': vowels[4] += delta; break;
        }
    }

    // 检查是否所有元音都至少出现一次
    private boolean allVowelsPresent(int[] vowels) {
        for (int v : vowels) {
            if (v == 0) return false;
        }
        return true;
    }

    // 计算元音总数
    private int sumVowels(int[] vowels) {
        int sum = 0;
        for (int v : vowels) {
            sum += v;
        }
        return sum;
    }
}
