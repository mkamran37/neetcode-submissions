class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt();
        int l = 1, r = max;
        int result = r;
        while (l <= r) {
            int mid = (l + r)/2;
            long total = hoursToEat(piles, mid);
            if (total <= h) {
                r = mid - 1;
                result = Math.min(result, mid);
            } else {
                l = mid + 1;
            }
        }
        return result;
    }

    private long hoursToEat(int[] piles, int k) {
        long result = 0;
        for (int pile: piles) {
            result += Math.ceil((double) pile/k);
        }
        return result;
    }
}
