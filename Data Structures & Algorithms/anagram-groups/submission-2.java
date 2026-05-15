class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs) {
            int[] chars = new int[26];
            for(char c: str.toCharArray()) {
                chars[c-'a'] += 1;
            }
            
            List<String> list = map.getOrDefault(Arrays.toString(chars), new ArrayList<>());
            list.add(str);
            map.put(Arrays.toString(chars), list);
        }
        return new ArrayList<>(map.values());
    }
}
