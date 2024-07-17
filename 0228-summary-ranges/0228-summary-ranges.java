class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 1) {
            res.add(String.valueOf(nums[0]));
            return res;
        }

        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (left == right) {
                right++;
            } else {
                if (nums[right] - nums[right-1] == 1) {
                    right++;
                } else {
                    if (right - left == 1) {
                        res.add(String.valueOf(nums[left]));
                        left = right;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append(String.valueOf(nums[left]));
                        sb.append("->");
                        sb.append(String.valueOf(nums[right - 1]));
                        left = right;
                        res.add(sb.toString());
                    }

                }
            }

        }
        if (left != right) {
            if (right - left == 1) {
                res.add(String.valueOf(nums[left]));
                left = right;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(String.valueOf(nums[left]));
                sb.append("->");
                sb.append(String.valueOf(nums[right - 1]));
                left = right;
                res.add(sb.toString());
            }
        }
        return res;
    }
}