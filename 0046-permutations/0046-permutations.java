class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> ret = new ArrayList<>();
        bt(ret, new ArrayList<>(), used, nums);
        return ret;
    }

    private void bt(List<List<Integer>> ret, List<Integer> l, boolean[] used, int[] nums) {
        if (l.size() == used.length) {
            ret.add(new ArrayList<>(l));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            l.add(nums[i]);
            bt(ret, l, used, nums);
            l.remove(l.size() - 1);
            used[i] = false;
        }
    }
}