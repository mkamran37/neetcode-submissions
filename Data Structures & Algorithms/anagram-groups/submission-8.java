class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        for (String s: strs) {
            group(s, map);
        }
        return new ArrayList<>(map.values());
    }

    private void group(String s, Map<String, List<String>> map) {
        int[] sc = new int[26];
        for (char c: s.toCharArray()) {
            sc[c - 'a']++;
        }
        String scs = Arrays.toString(sc);
        List<String> l = map.getOrDefault(scs, new ArrayList<String>());
        l.add(s);
        map.put(scs, l);
    }
}