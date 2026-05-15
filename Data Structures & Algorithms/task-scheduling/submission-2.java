class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Deque<int[]> q = new ArrayDeque<>();
        int time = 0;

        for(char task: tasks) {
            counts[task - 'A']++;
        }

        for(int count: counts) {
            if (count > 0) {
                pq.offer(count);
            }
        }

        while(!pq.isEmpty() || !q.isEmpty()) {
            time++;
            
            if(pq.isEmpty()) {
                time = q.getFirst()[1];
            } else {
                int count = pq.poll() - 1;
                if (count > 0) {
                    q.addLast(new int[]{count, time + n});
                }
            }
            if (!q.isEmpty() && q.getFirst()[1] == time) {
                pq.offer(q.removeFirst()[0]);
            }
        }
        return time;
    }
}
