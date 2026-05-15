class TimeMap {
    private final HashMap<String, List<Pair<Integer, String>>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        String result = "";
        if (map.containsKey(key)) {
            int l = 0;
            int r = map.get(key).size() - 1;
            while (l <= r) {
                int mid = l + (r - l)/2;
                if (map.get(key).get(mid).getKey() <= timestamp) {
                    result = map.get(key).get(mid).getValue();
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return result;
    }
}
