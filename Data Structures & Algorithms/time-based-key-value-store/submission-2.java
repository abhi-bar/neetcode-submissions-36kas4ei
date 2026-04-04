class TimeMap {

    private Map<String, TreeMap<Integer, String>> store;

    public TimeMap() {
        store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        store.putIfAbsent(key, new TreeMap<>());
        store.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!store.containsKey(key)) return "";
        Integer floorKey = store.get(key).floorKey(timestamp);
        if (floorKey == null) return "";
        return store.get(key).get(floorKey);
    }
    
}
