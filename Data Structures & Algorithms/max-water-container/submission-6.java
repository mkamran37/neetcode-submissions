class Solution {
    public int maxArea(int[] h) {
        int l = 0, r = h.length - 1;
        int result = 0;
        while (l < r) {
            int area = (r - l) * Math.min(h[l], h[r]);
            result = Math.max(result, area);
            if (h[l] > h[r]) {
                r--;
            } else {
                l++;
            }
        }
        return result;
    }
}
