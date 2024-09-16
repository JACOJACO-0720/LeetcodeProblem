class Solution {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());
    public int findKthLargest(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
        }
        for (int i = 0; i < k-1; i++) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}