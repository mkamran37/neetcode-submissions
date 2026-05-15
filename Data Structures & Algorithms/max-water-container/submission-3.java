class Solution {
    public int maxArea(int[] nums) {
        int l = 0, r = nums.length - 1, result = 0;
        while (l < r) {
            int length = r - l, height = Math.min(nums[l], nums[r]), vol = length * height;
            result = Math.max(result, vol);
            if (nums[l] < nums[r]) {
                l++;
            } else {
                r--;
            }
        }
        return result;
    }
}
