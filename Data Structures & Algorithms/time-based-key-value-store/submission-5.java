class TimeMap {
    Map<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (map.containsKey(key)) {
            return map.get(key).floorEntry(timestamp) != null ? map.get(key).floorEntry(timestamp).getValue() : "";
        }
        return "";
    }
}
