class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone: stones) {
            pq.offer(stone);
        }
        while (pq.size() >= 2) {
            int s1 = pq.poll(), s2 = pq.poll();
            if (s1 > s2) {
                pq.offer(s1 - s2);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
