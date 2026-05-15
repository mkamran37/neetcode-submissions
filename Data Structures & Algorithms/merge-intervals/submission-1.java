class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] newInterval = intervals[0];
        List<int[]> result = new ArrayList<>();
        for(int[] interval: intervals) {
            if (interval[0] > newInterval[1]) {
                // starttime of interval is greater than endtime of new interval
                // no overlap
                // just insert the newInterval directly
                // also mark this interval as new interval
                result.add(newInterval);
                newInterval = interval;
            } else if (interval[1] < newInterval[0]) {
                // endtime of interval is less than the starttime of new interval
                // no overlap
                // just insert the interval directly 
                // keep the newInterval as is no op
                result.add(interval);
            } else {
                // there is an overlap, set the new interval
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }
}
