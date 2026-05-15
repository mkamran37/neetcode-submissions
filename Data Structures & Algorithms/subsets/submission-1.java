class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, new ArrayDeque<>(), 0);
        return result;
    }

    private void backtrack(int[] nums, Deque<Integer> tmp, int start) {
        if (start >= nums.length) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        tmp.addLast(nums[start]);
        backtrack(nums, tmp, start + 1);
        tmp.removeLast();
        backtrack(nums, tmp, start + 1);
    }
}
