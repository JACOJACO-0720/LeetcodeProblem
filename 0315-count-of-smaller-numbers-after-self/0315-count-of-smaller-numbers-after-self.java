import java.util.*;

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        List<Integer> sortedList = new ArrayList<>(); // 用于模拟 SortedList

        // 逆序遍历
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];

            // 找到当前数的插入位置（二分查找）
            int idx = binarySearch(sortedList, num);
            result.add(idx);

            // 插入当前数到有序列表
            sortedList.add(idx, num);
        }

        // 结果翻转
        Collections.reverse(result);
        return result;
    }

    // 使用二分查找找到插入位置（相当于 bisect_left）
    private int binarySearch(List<Integer> sortedList, int target) {
        int left = 0, right = sortedList.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (sortedList.get(mid) >= target) {
                right = mid; // 左移，找到最左侧的插入位置
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
