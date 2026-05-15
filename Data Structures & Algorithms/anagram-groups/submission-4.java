class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs) {
            int[] charray = new int[26];
            for(char c: str.toCharArray()) {
                charray[c-'a']++;
            }
            String val = Arrays.toString(charray);
            List<String> arr = map.getOrDefault(val, new ArrayList<>());
            arr.add(str);
            map.put(val, arr);
        }
        return new ArrayList<>(map.values());
    }
}
