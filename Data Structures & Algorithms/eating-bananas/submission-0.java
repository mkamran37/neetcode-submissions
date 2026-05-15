class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = getMax(piles);
        int result = right;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (canEatAll(piles, h, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    private boolean canEatAll(int[] piles, int h, int k) {
        int hours = 0;
        for (int pile: piles) {
            hours += (pile + k - 1) / k;

        }
        return hours <= h;
    }

    private int getMax(int[] piles) {
        int max = 0;
        for (int pile: piles) {
            max = Math.max(pile, max);
        }
        return max;
    }
}
