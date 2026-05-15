class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for(char c: t.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
            map2.put(c, 0);
        }
        int l = 0, r = 0, have = 0, need = map1.size();
        int minLength = Integer.MAX_VALUE;
        int[] resultIndex = new int[2];
        while (r < s.length()) {
            if (!map2.containsKey(s.charAt(r))) {
                r++;
                continue;
            }
            map2.put(s.charAt(r), map2.get(s.charAt(r)) + 1);
            if (map2.get(s.charAt(r)) == map1.get(s.charAt(r))) {
                have++;
            }
            while (have == need) {
                if (r - l < minLength) {
                    resultIndex = new int[]{l, r + 1};
                    minLength = r - l;
                }
                if (map2.containsKey(s.charAt(l))) {
                    map2.put(s.charAt(l), map2.get(s.charAt(l)) - 1);
                    if (map2.get(s.charAt(l)) < map1.get(s.charAt(l))) {
                        have--;
                    }
                }
                l++;
            }
            r++;
        }
        return s.substring(resultIndex[0], resultIndex[1]);
    }
}
