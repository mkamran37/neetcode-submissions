/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        PriorityQueue<Integer> starts = new PriorityQueue<>();
        PriorityQueue<Integer> ends = new PriorityQueue<>();
        int result = 0;
        int count = 0;

        for (Interval in: intervals) {
            starts.offer(in.start);
            ends.offer(in.end);
        }
        while (!starts.isEmpty()) {
            if (starts.peek() < ends.peek()) {
                count++;
                starts.poll();
            } else {
                count--;
                ends.poll();
            }
            result = Math.max(count, result);
        }
        return result;
    }
}
