class Solution {
    public void nextPermutation(int[] nums) {
        int posi = nums.length - 1;

        // 1. 找到从后向前第一个不满足递增顺序的元素
        while (posi > 0 && nums[posi] <= nums[posi - 1]) {
            posi--;
        }

        if (posi == 0) {
            // 如果整个数组是非递增的，直接反转为最小排列
            reverse(nums, 0, nums.length - 1);
        } else {
            // 2. 找到比 nums[posi-1] 大的最小元素
            int left = posi;
            int right = nums.length - 1;
            int key = nums[posi - 1];
            int swapIndex = left;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > key) {
                    swapIndex = mid; // 更新可能的交换位置
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            // 3. 交换 nums[posi-1] 和找到的元素
            int temp = nums[swapIndex];
            nums[swapIndex] = nums[posi - 1];
            nums[posi - 1] = temp;

            // 4. 反转从 posi 开始的部分，使其为最小排列
            reverse(nums, posi, nums.length - 1);
        }
    }

    // 辅助方法：反转数组的一部分
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
