class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0, n = intervals.length;
        while(i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i++]);
        }
        while (i < n && newInterval[1] >= intervals[i][0]) {
            newInterval = new int[]{Math.min(intervals[i][0], newInterval[0]), Math.max(intervals[i][1], newInterval[1])};
            i++;
        }
        result.add(newInterval);
        while (i < n) {
            result.add(intervals[i++]);
        }
        return result.toArray(new int[result.size()][]);
    }
}
