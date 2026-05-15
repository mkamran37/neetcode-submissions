class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int result = 0;
        for(int i = 0, j = height.length - 1; i < height.length; i++, j--) {
            if (i == 0) {
                left[i] = height[i];
                right[j] = height[j];
                continue;
            }
            left[i] = Math.max(left[i - 1], height[i]);
            right[j] = Math.max(right[j + 1], height[j]);
        }
        for (int i = 0; i < height.length; i++) {
            result += Math.min(left[i], right[i]) - height[i];
        }
        return result;
    }
}
