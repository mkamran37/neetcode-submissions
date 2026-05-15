class Solution {
    public int trap(int[] height) {
        int[] maxleft = new int[height.length];
        int[] maxright = new int[height.length];
        int result = 0;
        for(int i = 0, j = height.length - 1; i < height.length; i++, j--) {
            if (i == 0) {
                maxleft[i] = height[i];
                maxright[j] = height[j];
                continue;
            }
            maxleft[i] = Math.max(maxleft[i - 1], height[i]);
            maxright[j] = Math.max(maxright[j+1], height[j]);
        }
        for (int i = 0; i < height.length; i++) {
            result += Math.min(maxleft[i], maxright[i]) - height[i];
        }
        return result;
    }
}
