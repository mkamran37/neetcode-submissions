class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            String key = convert(s);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    private String convert(String s) {
        int[] chars = new int[26];
        for(char c: s.toCharArray()) {
            chars[c - 'a']++;
        }
        return Arrays.toString(chars);
    }
}
