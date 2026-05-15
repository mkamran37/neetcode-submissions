class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            String s1 = convertToArray(str);
            map.computeIfAbsent(s1, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private String convertToArray(String s) {
        int[] tmp = new int[26];
        for(char c: s.toCharArray()) {
            tmp[c - 'a']++;
        }
        return Arrays.toString(tmp);
    }
}
