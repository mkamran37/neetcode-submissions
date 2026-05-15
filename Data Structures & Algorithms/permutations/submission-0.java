class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new ArrayDeque<>(), new HashSet<>());
        return result;
    }

    private void backtrack(int[] nums, Deque<Integer> tmp, Set<Integer> visited) {
        if (tmp.size() == nums.length) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited.contains(nums[i])) {
                tmp.addLast(nums[i]);
                visited.add(nums[i]);
                backtrack(nums, tmp, visited);
                visited.remove(nums[i]);
                tmp.removeLast();
            }
        }
    }
}
