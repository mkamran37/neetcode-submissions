class LRUCache {
    private int capacity;
    private Map<Integer, Integer> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>(capacity, 0.75f, true) {
            public boolean removeEldestEntry(Map.Entry<Integer, Integer> entry) {
                return size() > LRUCache.this.capacity;
            }
        };
    }
    
    public int get(int key) {
        return map.containsKey(key) ? map.get(key) : -1;
    }
    
    public void put(int key, int value) {
        map.put(key, value);
    }
}
