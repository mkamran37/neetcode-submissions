class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        for (Integer key: map.keySet()) {
            pq.offer(new int[]{key, map.get(key)});
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int i = 0;
        while (!pq.isEmpty()) {
            result[i++] = pq.poll()[0];
        }
        return result;
    }
}
