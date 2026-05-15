class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] result = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            result[i++] = pq.poll()[0];
        }
        return result;
    }
}
