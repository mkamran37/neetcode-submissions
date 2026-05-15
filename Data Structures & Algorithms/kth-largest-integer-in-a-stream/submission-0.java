class KthLargest {
    PriorityQueue<Integer> minHeap;
    Integer k;

    public KthLargest(int k, int[] nums) {
        this.minHeap = new PriorityQueue<Integer>();
        this.k = k;
        for (int num: nums) {
            this.minHeap.add(num);
        }
    }
    
    public int add(int val) {
        this.minHeap.add(val);
        while (this.minHeap.size() > this.k) {
            this.minHeap.remove();
        }
        return this.minHeap.peek();
    }
}
