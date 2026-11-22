class TimeMap {

    private final Map<String, TreeMap<Integer, String>> cache;

    public TimeMap() {
        cache = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        cache.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!cache.containsKey(key))
            return "";
        TreeMap<Integer, String> timestamps = cache.get(key);
        Map.Entry<Integer, String> value = timestamps.floorEntry(timestamp);
        return value == null ? "" : value.getValue();
    }
}
