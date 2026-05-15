class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int result = 0;
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int i = 0, end = intervals[i][1];
        i++;
        while (i < intervals.length) {
            if (intervals[i][0] < end) {
                end = Math.min(intervals[i][1], end);
                result++;
            } else {
                end = intervals[i][1];
            }
            i++;
        }
        return result;
    }
}
