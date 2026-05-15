class Solution {
    Set<List<Integer>> result = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayDeque<>());
        return new ArrayList<>(result);
    }

    private void backtrack(int[] nums, int start, Deque<Integer> tmp) {
        if (start > nums.length) {
            return;
        }
        if (start == nums.length) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        tmp.offerLast(nums[start]);
        backtrack(nums, start + 1, tmp);
        tmp.removeLast();
        backtrack(nums, start + 1, tmp);
    }
}
