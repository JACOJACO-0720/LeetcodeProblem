class Solution {
    public int missingElement(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;

        // 辅助方法，计算缺失的总数
        // 从 nums[0] 到 nums[index] 缺失的数字数量


        // 检查 k 是否超过整个数组范围的缺失数字
        if (k > getMissingCount(right,nums)) {
            return nums[right] + (k - getMissingCount(right,nums));
        }

        // 二分查找
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (getMissingCount(mid,nums) < k) {
                left = mid + 1; // 缺失的数量不足，需要往右边找
            } else {
                right = mid; // 缺失的数量过多，需要往左边找
            }
        }

        // 最后定位到 left == right，找到缺失数字的范围
        return nums[left - 1] + (k - getMissingCount(left - 1,nums));
    }
            int getMissingCount(int index, int[] nums) {
            return nums[index] - nums[0] - index;
        }
}