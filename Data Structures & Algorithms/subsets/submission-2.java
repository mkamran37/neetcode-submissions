class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayDeque<>());
        return result;
    }

    private void backtrack(int[] nums, int start, Deque<Integer> dq) {
        if (start == nums.length) {
            result.add(new ArrayList<>(dq));
            return;
        }
        dq.addLast(nums[start]);
        backtrack(nums, start + 1, dq);
        dq.removeLast();
        backtrack(nums, start + 1, dq);
    }
}
