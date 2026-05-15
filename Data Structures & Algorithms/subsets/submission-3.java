class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, new ArrayDeque<>(), 0);
        return result;
    }

    private void backtrack(int[] nums, Deque<Integer> dq, int start) {
        if (start == nums.length) {
            result.add(new ArrayList<>(dq));
            return;
        }
        dq.addLast(nums[start]);
        backtrack(nums, dq, start+1);
        dq.removeLast();
        backtrack(nums, dq, start+1);
    }
}
