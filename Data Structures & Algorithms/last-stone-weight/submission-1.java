class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int stone: stones) {
            pq.offer(stone);
        }
        while (pq.size() > 1) {
            int y = pq.remove();
            int x = pq.remove();
            if (x < y) {
                pq.offer(y-x);
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}
