class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for (Integer key: map.keySet()) {
            pq.offer(new int[]{map.get(key), key});
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll()[1];
        }
        return result;
    }
}
