class KthLargest {
    PriorityQueue<Integer> pq;
    Integer k;
    
    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.k = k;
        for (int num: nums) {
            pq.offer(num);
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        while (pq.size() > k) {
            pq.remove();
        }
        return pq.peek();
    }
}
