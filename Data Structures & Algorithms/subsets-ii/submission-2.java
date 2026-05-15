class Solution {
    Set<List<Integer>> result = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayDeque<>());
        return new ArrayList<>(result);
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
