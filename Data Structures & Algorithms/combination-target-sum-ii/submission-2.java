class Solution {
    Set<List<Integer>> result = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayDeque<>());
        return new ArrayList<>(result);
    }

    private void backtrack(int[] candidates, int target, int start, Deque<Integer> dq) {
        if (target == 0) {
            result.add(new ArrayList<>(dq));
            return;
        }
        if (start >= candidates.length || target < 0) {
            return;
        }
        dq.addLast(candidates[start]);
        backtrack(candidates, target - candidates[start], start+1, dq);
        dq.removeLast();
        backtrack(candidates, target, start+1, dq);
    }
}
