class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs) {
            int[] ind = new int[26];
            for (char c: s.toCharArray()) {
                ind[c-'a']++;
            }
            List<String> list = map.getOrDefault(Arrays.toString(ind), new ArrayList());
            list.add(s);
            map.put(Arrays.toString(ind), list);
        }
        List<List<String>> result = new ArrayList<>();
        for(List<String> list: map.values()) {
            result.add(list);
        }
        return result;
    }
}
