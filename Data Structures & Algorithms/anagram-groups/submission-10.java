class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            int[] tmp = new int[26];
            for (char c: str.toCharArray()) {
                tmp[c - 'a']++;
            }
            map.computeIfAbsent(Arrays.toString(tmp), k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());

    }
}
