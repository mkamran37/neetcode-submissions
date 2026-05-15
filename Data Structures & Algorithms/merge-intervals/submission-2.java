class Solution {
    public int[][] merge(int[][] intervals) {
        Deque<int[]> result = new ArrayDeque<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int[] interval: intervals) {
            if (result.isEmpty() || result.getLast()[1] < interval[0]) {
                result.addLast(interval);
            } else {
                result.getLast()[1] = Math.max(result.getLast()[1], interval[1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
