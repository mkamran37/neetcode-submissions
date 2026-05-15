class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for (int stone: stones) {
            pq.offer(stone);
        }
        while (pq.size() > 1) {
            int a = pq.poll(), b = pq.poll();
            if (a == b) {
                continue;
            } else {
                pq.offer(a - b);
            }
        }
        return pq.size() == 1 ? pq.poll() : 0;
    }
}
