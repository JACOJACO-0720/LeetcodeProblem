import java.util.List;

public class Solution {

    public void quickSort(int[] unsorted) {
        quickSort(unsorted, 0, unsorted.length - 1);
    }

    private static void quickSort(int[] unsorted, int left, int right) {
        // base case
        if (left >= right) {
            return;
        }

        int pivot = unsorted[right];
        int partition = partition(unsorted, left, right, pivot);

        quickSort(unsorted, left, partition - 1);
        quickSort(unsorted, partition + 1, right);
    }

    private static int partition(int[] arr, int left, int right, int pivot) {
        // make both leftPointer and rightPointer exclusive initially
        int leftPointer = left - 1;
        int rightPointer = right;

        while (true) {
            // scanning to find out-of-place values
            while (arr[++leftPointer] < pivot) ;
            while (rightPointer > left && arr[--rightPointer] > pivot) ;
            if (leftPointer >= rightPointer) {
                // nothing to swap
                break;
            }
            // swap out-of-place values
            swap(arr, leftPointer, rightPointer);
        }
        // put pivot value into the right location (also, its final position)
        swap(arr, leftPointer, right);
        // return index where the pivot value ends up
        return leftPointer;
    }

    private static void swap(int[] data, int one, int two) {
        int tmp = data[one];
        data[one] = data[two];
        data[two] = tmp;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Solution solution = new Solution();
        solution.quickSort(nums);
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            left = i+1;
            right = nums.length - 1;
            int target = -nums[i];
            while (left < right) {
                int tempSum = nums[left] + nums[right];
                if (tempSum == target) {
                    List<Integer> myList = new ArrayList<>();
                    myList.add(nums[i]);
                    myList.add(nums[left]);
                    myList.add(nums[right]);
                    if (result.isEmpty()||!myList.equals(result.get(result.size()-1))) {
                        result.add(myList);
                    }
                    left++;
                    right--;
                } else if (tempSum>target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = {-1,0,1,2,-1,-4};
        Solution solution=new Solution();
        System.out.println(solution.threeSum(nums));
    }
}
