class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Comparator<int[]> comparator = (a, b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>(comparator);
        for (int[] point: points) {
            pq.offer(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[][] result = new int[k][2];
        while (!pq.isEmpty()) {
            result[--k] = pq.poll();
        }
        return result;
    }
}
