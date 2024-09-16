class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 确保 nums1 是较短的数组
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int totalLeft = (m + n + 1) / 2;

        int left = 0;
        int right = m;

        while (left <= right) {
            int i = left + (right - left) / 2;
            int j = totalLeft - i;

            int nums_im1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int nums_i = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int nums_jm1 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int nums_j = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (nums_im1 <= nums_j) {
                if (nums_jm1 <= nums_i) {
                    // 找到合适的分割点
                    if ((m + n) % 2 == 1) {
                        return Math.max(nums_im1, nums_jm1);
                    } else {
                        return (Math.max(nums_im1, nums_jm1) + Math.min(nums_i, nums_j)) / 2.0;
                    }
                } else {
                    // nums_jm1 > nums_i，i 需要增大
                    left = i + 1;
                }
            } else {
                // nums_im1 > nums_j，i 需要减小
                right = i - 1;
            }
        }

        throw new IllegalArgumentException("输入的数组不合法，无法找到中位数。");
    }
}
