class Solution {
    List<List<Integer>> result = new ArrayList<>();
    HashSet<Integer> set = new HashSet<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new ArrayDeque<>());
        return result;
    }

    private void backtrack(int[] nums, Deque<Integer> dq) {
        if (dq.size() == nums.length) {
            result.add(new ArrayList<>(dq));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                dq.addLast(nums[i]);
                set.add(nums[i]);
                backtrack(nums, dq);
                set.remove(nums[i]);
                dq.removeLast();
            }
        }
    }
}
