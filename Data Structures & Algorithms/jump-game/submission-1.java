class Solution {
    public boolean canJump(int[] nums) {
        return dfs(nums, 0);
    }

    private boolean dfs(int[] nums, int curr) {
        if (curr >= nums.length - 1) {
            return true;
        }
        for (int i = curr + 1; i <= Math.min(curr + nums[curr], nums.length - 1); i++) {
            if (dfs(nums, i)) return true;
        }
        return false;
    }
}
