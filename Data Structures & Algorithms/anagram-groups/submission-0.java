class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s: strs) {
            int[] charray = new int[128];
            for(char c: s.toCharArray()) {
              charray[c] += 1;
            }
            String chars = Arrays.toString(charray);
            if (map.containsKey(chars)) {
                map.get(chars).add(s);
            } else {
                List<String> st = new ArrayList<>();
                st.add(s);
                map.put(chars, st);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(List<String> r: map.values()) {
            result.add(r);
        }
        return result;
    }
}
