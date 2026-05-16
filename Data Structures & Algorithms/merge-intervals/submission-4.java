class Solution {
    public int[][] merge(int[][] intervals) {
        Deque<int[]> result = new ArrayDeque<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for(int[] i: intervals) {
            pq.offer(i);
        }

        while(!pq.isEmpty()) {
            if(result.isEmpty() || result.getLast()[1] < pq.peek()[0]) {
                result.addLast(pq.poll());
            } else {
                result.getLast()[1] = Math.max(result.getLast()[1], pq.poll()[1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
