class Solution {
    Set<List<Integer>> result = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, new ArrayDeque<>(), 0);
        return new ArrayList<>(result);
    }

    private void backtrack(int[] nums, Deque<Integer> dq, int start) {
        if (start == nums.length) {
            result.add(new ArrayList<>(dq));
            return;
        }
        if (start > nums.length) {
            return;
        }
        dq.addLast(nums[start]);
        backtrack(nums, dq, start + 1);
        dq.removeLast();
        backtrack(nums, dq, start + 1);
    }
}
