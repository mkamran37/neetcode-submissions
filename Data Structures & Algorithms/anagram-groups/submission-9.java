class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (String s: strs) {
            String anagram = getAnagramString(s);
            result.computeIfAbsent(anagram, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(result.values());
    }

    public String getAnagramString(String s1) {
        int[] s = new int[26];
        for (char c: s1.toCharArray()) {
            s[c - 'a']++;
        }
        return Arrays.toString(s);
    }
}
